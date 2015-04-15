package com.jpbnetsoftware.fdbscript.compiler;

import com.jpbnetsoftware.fdbscript.compiler.antlr.FdbScriptBaseVisitor;
import com.jpbnetsoftware.fdbscript.compiler.generator.*;
import com.jpbnetsoftware.fdbscript.compiler.antlr.FdbScriptParser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pawel on 30/03/15.
 */
public class FdbScriptAstVisitor extends FdbScriptBaseVisitor<ICodeBlock> {

    private IGenerator generator;

    private ScopeManager scope;

    public FdbScriptAstVisitor(IGenerator generator) {
        this.generator = generator;
        this.scope = new ScopeManager();
    }

    @Override
    public ICodeBlock visitProgramDeclaration(@NotNull FdbScriptParser.ProgramDeclarationContext ctx) {

        this.scope.pushScope();

        List<ICodeBlock> definitions = new ArrayList<ICodeBlock>();

        for (FdbScriptParser.DefinitionExpressionContext d : ctx.definitionExpression()) {
            definitions.add(this.visitDefinitionExpression(d));
        }

        return generator.generateModule(
                ctx.MODULEID().toString(),
                definitions,
                this.visitExpression(ctx.expression()));
    }

    @Override
    public ICodeBlock visitDefinitionExpression(@NotNull FdbScriptParser.DefinitionExpressionContext ctx) {

        String name = ctx.ID().toString();
        ICodeBlock expression = this.visitExpression(ctx.expression());
        IDefinitionCodeBlock definition = this.generator.generateDefinition(name, expression);

        this.scope.getCurrentScope().addDefinition(name, definition);

        return definition;
    }

    @Override
    public ICodeBlock visitFunctionDeclaration(@NotNull FdbScriptParser.FunctionDeclarationContext ctx) {

        this.scope.pushScope();

        this.generator.beginGenerateFunction();
        this.scope.getCurrentScope().addDefinition("self", this.generator.generateSelfDefinition());

        List<ICodeBlock> argumentDefinitions = new ArrayList<ICodeBlock>();

        for (TerminalNode arg : ctx.ID()) {
            String name = arg.toString();
            IDefinitionCodeBlock definition = this.generator.generateArgumentDefinition(name);

            argumentDefinitions.add(definition);
            this.scope.getCurrentScope().addDefinition(name, definition);
        }

        List<ICodeBlock> definitions = new ArrayList<ICodeBlock>();

        for (FdbScriptParser.DefinitionExpressionContext d : ctx.definitionExpression()) {
            definitions.add(this.visitDefinitionExpression(d));
        }

        ICodeBlock func = this.generator.generateFunction(argumentDefinitions, definitions, this.visitExpression(ctx.expression()));

        this.scope.popScope();

        return func;
    }

    @Override
    public ICodeBlock visitInvokeExpression(@NotNull FdbScriptParser.InvokeExpressionContext ctx) {

        String name = ctx.ID().toString();
        IDefinitionCodeBlock definition = this.scope.getCurrentScope().findDefinition(name);
        List<ICodeBlock> arguments = new ArrayList<ICodeBlock>();

        for (FdbScriptParser.ExpressionContext e : ctx.expression()) {
            arguments.add(this.visitExpression(e));
        }

        if (definition == null) {
            System.out.println("Unable to find definition of: " + ctx.ID());
        }

        return this.generator.generateInvoke(definition, arguments);
    }

    @Override
    public ICodeBlock visitIfExpression(@NotNull FdbScriptParser.IfExpressionContext ctx) {

        List<ICodeBlock> conditions = new ArrayList<ICodeBlock>();

        for (FdbScriptParser.ConditionClauseContext c : ctx.conditionClause()) {
            conditions.add(this.visitConditionClause(c));
        }

        return this.generator.generateIf(conditions, this.visitElseClause(ctx.elseClause()));
    }

    @Override
    public ICodeBlock visitConditionClause(@NotNull FdbScriptParser.ConditionClauseContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ICodeBlock visitElseClause(@NotNull FdbScriptParser.ElseClauseContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ICodeBlock visitExpression(@NotNull FdbScriptParser.ExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ICodeBlock visitValueExpression(@NotNull FdbScriptParser.ValueExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ICodeBlock visitMathExpression(@NotNull FdbScriptParser.MathExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ICodeBlock visitAdditiveExpression(@NotNull FdbScriptParser.AdditiveExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ICodeBlock visitMultiplicativeExpression(@NotNull FdbScriptParser.MultiplicativeExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ICodeBlock visitCompareExpression(@NotNull FdbScriptParser.CompareExpressionContext ctx) {
        return visitChildren(ctx);
    }
    
    @Override
    public ICodeBlock visitLogicalExpression(@NotNull FdbScriptParser.LogicalExpressionContext ctx) {
        return visitChildren(ctx);
    }




    /*
    @Override
    public ICodeBlock visitConditionClause(@NotNull FdbScriptParser.ConditionClauseContext ctx) {
        return this.generator.generateCondition(
                this.visitBooleanExpression(ctx.booleanExpression()),
                this.visitExpression(ctx.expression()));
    }

    @Override
    public ICodeBlock visitElseClause(@NotNull FdbScriptParser.ElseClauseContext ctx) {
        return this.generator.generateElse(this.visitExpression(ctx.expression()));
    }

    @Override
    public ICodeBlock visitComputedExpression(@NotNull FdbScriptParser.ComputedExpressionContext ctx) {

        if (ctx.ID() != null) {
            IDefinitionCodeBlock definition = this.scope.getCurrentScope().findDefinition(ctx.ID().toString());

            if (definition == null) {
                System.out.println("Unable to find definition of: " + ctx.ID());
            }

            return this.generator.generateDefinitionInvoke(definition);
        }

        return super.visitComputedExpression(ctx);
    }

    @Override
    public ICodeBlock visitBooleanExpression(@NotNull FdbScriptParser.BooleanExpressionContext ctx) {

        if (ctx.TRUE() != null) {
            return this.generator.generateBoolPrimitive(true);
        }

        if (ctx.FALSE() != null) {
            return this.generator.generateBoolPrimitive(false);
        }

        if (ctx.booleanExpression().size() == 2) {
            BooleanOperation operation =
                    ctx.AND() != null ? BooleanOperation.And :
                            ctx.OR() != null ? BooleanOperation.Or : null;

            return this.generator.generateBoolean(
                    this.visitBooleanExpression(ctx.booleanExpression(0)),
                    operation,
                    this.visitBooleanExpression(ctx.booleanExpression(1)));
        }

        return super.visitBooleanExpression(ctx);
    }

    @Override
    public ICodeBlock visitEqualityExpression(@NotNull FdbScriptParser.EqualityExpressionContext ctx) {

        if (ctx.equalityOperand().size() == 2) {
            return this.generator.generateEqualityTest(
                    this.visitEqualityOperand(ctx.equalityOperand(0)),
                    ctx.EQ() != null,
                    this.visitEqualityOperand(ctx.equalityOperand(1)));
        }

        return super.visitEqualityExpression(ctx);
    }

    @Override
    public ICodeBlock visitEqualityOperand(@NotNull FdbScriptParser.EqualityOperandContext ctx) {

        if (ctx.TRUE() != null) {
            return this.generator.generateBoolPrimitive(true);
        }

        if (ctx.FALSE() != null) {
            return this.generator.generateBoolPrimitive(false);
        }

        return super.visitEqualityOperand(ctx);
    }

    @Override
    public ICodeBlock visitCompareExpression(@NotNull FdbScriptParser.CompareExpressionContext ctx) {

        if (ctx.mathExpression().size() == 2) {
            CompareOperation operation =
                    ctx.GE() != null ? CompareOperation.GreaterEqual :
                            ctx.GT() != null ? CompareOperation.GreaterThan :
                                    ctx.LE() != null ? CompareOperation.LessEqual :
                                            ctx.LT() != null ? CompareOperation.LessThan : null;

            return this.generator.generateCompare(
                    this.visitMathExpression(ctx.mathExpression(0)),
                    operation,
                    this.visitMathExpression(ctx.mathExpression(1)));
        }

        return super.visitCompareExpression(ctx);
    }

    @Override
    public ICodeBlock visitMathExpression(@NotNull FdbScriptParser.MathExpressionContext ctx) {

        if (ctx.NUMBER() != null) {
            return generator.generateNumber(Double.parseDouble(ctx.NUMBER().toString()));
        }

        if (ctx.mathExpression().size() == 2) {
            MathOperation operation =
                    ctx.PLUS() != null ? MathOperation.Plus :
                            ctx.MINUS() != null ? MathOperation.Minus :
                                    ctx.MUL() != null ? MathOperation.Mul :
                                            ctx.DIV() != null ? MathOperation.Div : null;

            return generator.generateMath(
                    this.visitMathExpression(ctx.mathExpression(0)),
                    operation,
                    this.visitMathExpression(ctx.mathExpression(1)));
        }

        return super.visitMathExpression(ctx);
    }

    @Override
    public ICodeBlock visitStringExpression(@NotNull FdbScriptParser.StringExpressionContext ctx) {

        if (ctx.STRING() != null) {
            return generator.generateString(ctx.STRING().toString().replace("\"", ""));
        }

        if (ctx.PLUS() != null) {
            return generator.generateStringConcat(this.visit(ctx.getChild(0)), this.visit(ctx.getChild(2)));
        }

        return super.visitStringExpression(ctx);
    }

    @Override
    protected ICodeBlock aggregateResult(ICodeBlock aggregate, ICodeBlock nextResult) {
        return nextResult == null ? aggregate : nextResult;
    }

    */
}
