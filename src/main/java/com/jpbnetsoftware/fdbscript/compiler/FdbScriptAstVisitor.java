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

        this.scope.getCurrentScope().addDefinition("self", this.generator.generateSelfDefinition());

        List<IDefinitionCodeBlock> argumentDefinitions = new ArrayList<IDefinitionCodeBlock>();

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

        String functionName = ctx.ID().toString();
        List<ICodeBlock> arguments = new ArrayList<ICodeBlock>();

        for (FdbScriptParser.ExpressionContext e : ctx.expression()) {
            arguments.add(this.visitExpression(e));
        }

        return this.generator.generateInvoke(functionName, arguments);
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
        return this.generator.generateCondition(
                this.visitExpression(ctx.expression(0)),
                this.visitExpression(ctx.expression(1)));
    }

    @Override
    public ICodeBlock visitElseClause(@NotNull FdbScriptParser.ElseClauseContext ctx) {
        return this.generator.generateElse(this.visitExpression(ctx.expression()));
    }

    @Override
    public ICodeBlock visitValueExpression(@NotNull FdbScriptParser.ValueExpressionContext ctx) {

        if (ctx.NOT() != null) {
            // TODO: not implemented
        }

        if (ctx.ID() != null) {
            IDefinitionCodeBlock definition = this.scope.getCurrentScope().findDefinition(ctx.ID().toString());

            if (definition == null) {
                System.out.println("Unable to find definition of: " + ctx.ID());
            }

            return this.generator.generateDefinitionInvoke(definition);
        }

        if (ctx.TRUE() != null) {
            return this.generator.generateBoolPrimitive(true);
        }

        if (ctx.FALSE() != null) {
            return this.generator.generateBoolPrimitive(false);
        }

        if (ctx.NUMBER() != null) {
            return this.generator.generateNumber(Double.parseDouble(ctx.NUMBER().toString()));
        }

        if (ctx.STRING() != null) {
            return this.generator.generateString(ctx.STRING().toString().replace("\"", ""));
        }

        return super.visitValueExpression(ctx);
    }

    @Override
    public ICodeBlock visitAdditiveExpression(@NotNull FdbScriptParser.AdditiveExpressionContext ctx) {
        if (ctx.additiveExpression() != null && ctx.multiplicativeExpression() != null) {
            MathOperation operation =
                    ctx.PLUS() != null ? MathOperation.Plus :
                            ctx.MINUS() != null ? MathOperation.Minus : null;

            return generator.generateMath(
                    this.visitAdditiveExpression(ctx.additiveExpression()),
                    operation,
                    this.visitMultiplicativeExpression(ctx.multiplicativeExpression()));
        }

        return super.visitAdditiveExpression(ctx);
    }

    @Override
    public ICodeBlock visitMultiplicativeExpression(@NotNull FdbScriptParser.MultiplicativeExpressionContext ctx) {

        if (ctx.multiplicativeExpression() != null && ctx.valueExpression() != null) {
            MathOperation operation =
                    ctx.MUL() != null ? MathOperation.Mul :
                            ctx.DIV() != null ? MathOperation.Div : null;

            return generator.generateMath(
                    this.visitMultiplicativeExpression(ctx.multiplicativeExpression()),
                    operation,
                    this.visitValueExpression(ctx.valueExpression()));
        }

        return super.visitMultiplicativeExpression(ctx);
    }

    @Override
    public ICodeBlock visitCompareExpression(@NotNull FdbScriptParser.CompareExpressionContext ctx) {

        if (ctx.compareExpression() != null && ctx.mathExpression() != null) {
            CompareOperation operation =
                    ctx.GE() != null ? CompareOperation.GreaterEqual :
                            ctx.GT() != null ? CompareOperation.GreaterThan :
                                    ctx.LE() != null ? CompareOperation.LessEqual :
                                            ctx.LT() != null ? CompareOperation.LessThan :
                                                    ctx.EQ() != null ? CompareOperation.Equal :
                                                            ctx.NEQ() != null ? CompareOperation.NotEqual : null;

            return this.generator.generateCompare(
                    this.visitCompareExpression(ctx.compareExpression()),
                    operation,
                    this.visitMathExpression(ctx.mathExpression()));
        }

        return super.visitCompareExpression(ctx);
    }

    @Override
    public ICodeBlock visitLogicalExpression(@NotNull FdbScriptParser.LogicalExpressionContext ctx) {

        if (ctx.logicalExpression() != null && ctx.compareExpression() != null) {
            BooleanOperation operation =
                    ctx.AND() != null ? BooleanOperation.And :
                            ctx.OR() != null ? BooleanOperation.Or : null;

            return this.generator.generateBoolean(
                    this.visitLogicalExpression(ctx.logicalExpression()),
                    operation,
                    this.visitCompareExpression(ctx.compareExpression()));
        }

        return super.visitLogicalExpression(ctx);
    }

    @Override
    protected ICodeBlock aggregateResult(ICodeBlock aggregate, ICodeBlock nextResult) {
        return nextResult == null ? aggregate : nextResult;
    }
}
