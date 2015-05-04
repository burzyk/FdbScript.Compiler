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

    public FdbScriptAstVisitor(IGenerator generator) {
        this.generator = generator;
    }

    @Override
    public ICodeBlock visitProgramDeclaration(@NotNull FdbScriptParser.ProgramDeclarationContext ctx) {

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

        return this.generator.generateDefinition(name, expression);
    }

    @Override
    public ICodeBlock visitDefinitionInvokeExpression(@NotNull FdbScriptParser.DefinitionInvokeExpressionContext ctx) {
        return this.generator.generateDefinitionInvoke(ctx.ID().toString());
    }

    @Override
    public ICodeBlock visitFunctionDeclaration(@NotNull FdbScriptParser.FunctionDeclarationContext ctx) {

        List<String> argumentDefinitions = new ArrayList<String>();

        for (TerminalNode arg : ctx.ID()) {
            argumentDefinitions.add(arg.toString());
        }

        List<ICodeBlock> definitions = new ArrayList<ICodeBlock>();

        for (FdbScriptParser.DefinitionExpressionContext d : ctx.definitionExpression()) {
            definitions.add(this.visitDefinitionExpression(d));
        }

        ICodeBlock func = this.generator.generateFunction(argumentDefinitions, definitions, this.visitExpression(ctx.expression()));

        return func;
    }

    @Override
    public ICodeBlock visitInvokeExpression(@NotNull FdbScriptParser.InvokeExpressionContext ctx) {

        ICodeBlock definitionInvoke = this.visitDefinitionInvokeExpression(ctx.definitionInvokeExpression());
        List<ICodeBlock> arguments = new ArrayList<ICodeBlock>();

        for (FdbScriptParser.ExpressionContext e : ctx.expression()) {
            arguments.add(this.visitExpression(e));
        }

        return this.generator.generateInvoke(definitionInvoke, arguments);
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
    public ICodeBlock visitListExpression(@NotNull FdbScriptParser.ListExpressionContext ctx) {

        List<ICodeBlock> initValues = new ArrayList<ICodeBlock>();

        for (FdbScriptParser.ExpressionContext e : ctx.expression()) {
            initValues.add(this.visitExpression(e));
        }

        return this.generator.generateList(initValues);
    }

    @Override
    public ICodeBlock visitIndexExpression(@NotNull FdbScriptParser.IndexExpressionContext ctx) {

        ICodeBlock first = ctx.expression().size() > 0 ? this.visitExpression(ctx.expression(0)) : null;
        ICodeBlock second = ctx.expression().size() > 1 ? this.visitExpression(ctx.expression(1)) : null;

        return this.generator.generateIndex(first, second, ctx.INDEXSEPARATOR() != null);
    }

    @Override
    public ICodeBlock visitListAccessExpression(@NotNull FdbScriptParser.ListAccessExpressionContext ctx) {
        List<ICodeBlock> indexExpressions = new ArrayList<ICodeBlock>();

        for (FdbScriptParser.IndexExpressionContext i : ctx.indexExpression()) {
            indexExpressions.add(this.visitIndexExpression(i));
        }

        return this.generator.generateListAccess(
                this.visitListAccessArgExpression(ctx.listAccessArgExpression()),
                indexExpressions);
    }

    @Override
    public ICodeBlock visitValueExpression(@NotNull FdbScriptParser.ValueExpressionContext ctx) {

        if (ctx.NOT() != null) {
            // TODO: not implemented
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
    public ICodeBlock visitListConcatExpression(@NotNull FdbScriptParser.ListConcatExpressionContext ctx) {

        if (ctx.listConcatExpression() != null && ctx.additiveExpression() != null) {
            return this.generator.generateListConcat(
                    this.visitListConcatExpression(ctx.listConcatExpression()),
                    this.visitAdditiveExpression(ctx.additiveExpression()));
        }

        return super.visitListConcatExpression(ctx);
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
