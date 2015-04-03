package com.jpbnetsoftware.fdbscriptcompiler;

import com.jpbnetsoftware.fdbscriptcompiler.antlr.FdbScriptBaseVisitor;
import com.jpbnetsoftware.fdbscriptcompiler.antlr.FdbScriptParser;
import com.jpbnetsoftware.fdbscriptcompiler.generator.CompareOperation;
import com.jpbnetsoftware.fdbscriptcompiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscriptcompiler.generator.IGenerator;
import com.jpbnetsoftware.fdbscriptcompiler.generator.MathOperation;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;

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

        return generator.generateModule(
                ctx.MODULEID().toString(),
                new ArrayList<ICodeBlock>(),
                this.visitExpression(ctx.expression()));
    }

    @Override
    public ICodeBlock visitAssignmentExpression(@NotNull FdbScriptParser.AssignmentExpressionContext ctx) {
        return super.visitAssignmentExpression(ctx);
    }

    @Override
    public ICodeBlock visitFunctionDeclaration(@NotNull FdbScriptParser.FunctionDeclarationContext ctx) {
        return super.visitFunctionDeclaration(ctx);
    }

    @Override
    public ICodeBlock visitInvokeExpression(@NotNull FdbScriptParser.InvokeExpressionContext ctx) {
        return super.visitInvokeExpression(ctx);
    }

    @Override
    public ICodeBlock visitIfExpression(@NotNull FdbScriptParser.IfExpressionContext ctx) {
        return super.visitIfExpression(ctx);
    }

    @Override
    public ICodeBlock visitConditionClause(@NotNull FdbScriptParser.ConditionClauseContext ctx) {
        return super.visitConditionClause(ctx);
    }

    @Override
    public ICodeBlock visitElseClause(@NotNull FdbScriptParser.ElseClauseContext ctx) {
        return super.visitElseClause(ctx);
    }

    @Override
    public ICodeBlock visitExpression(@NotNull FdbScriptParser.ExpressionContext ctx) {
        return super.visitExpression(ctx);
    }

    @Override
    public ICodeBlock visitComputedExpression(@NotNull FdbScriptParser.ComputedExpressionContext ctx) {
        return super.visitComputedExpression(ctx);
    }

    @Override
    public ICodeBlock visitBooleanExpression(@NotNull FdbScriptParser.BooleanExpressionContext ctx) {
        return super.visitBooleanExpression(ctx);
    }

    @Override
    public ICodeBlock visitEqualityExpression(@NotNull FdbScriptParser.EqualityExpressionContext ctx) {
        return super.visitEqualityExpression(ctx);
    }

    @Override
    public ICodeBlock visitEqualityOperand(@NotNull FdbScriptParser.EqualityOperandContext ctx) {
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
            return generator.generateNumber(Float.parseFloat(ctx.NUMBER().toString()));
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

        if(ctx.STRING() != null) {
            return generator.generateString(ctx.STRING().toString());
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
}
