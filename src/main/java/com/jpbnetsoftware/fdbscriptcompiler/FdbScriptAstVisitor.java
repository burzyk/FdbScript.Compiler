package com.jpbnetsoftware.fdbscriptcompiler;

import com.jpbnetsoftware.fdbscriptcompiler.antlr.FdbScriptBaseVisitor;
import com.jpbnetsoftware.fdbscriptcompiler.antlr.FdbScriptParser;
import org.antlr.v4.runtime.misc.NotNull;

/**
 * Created by pawel on 30/03/15.
 */
public class FdbScriptAstVisitor extends FdbScriptBaseVisitor<Void> {

    @Override
    public Void visitProgramDeclaration(@NotNull FdbScriptParser.ProgramDeclarationContext ctx) {
        return super.visitProgramDeclaration(ctx);
    }

    @Override
    public Void visitAssignmentExpression(@NotNull FdbScriptParser.AssignmentExpressionContext ctx) {
        return super.visitAssignmentExpression(ctx);
    }

    @Override
    public Void visitFunctionDeclaration(@NotNull FdbScriptParser.FunctionDeclarationContext ctx) {
        return super.visitFunctionDeclaration(ctx);
    }

    @Override
    public Void visitInvokeExpression(@NotNull FdbScriptParser.InvokeExpressionContext ctx) {
        return super.visitInvokeExpression(ctx);
    }

    @Override
    public Void visitIfExpression(@NotNull FdbScriptParser.IfExpressionContext ctx) {
        return super.visitIfExpression(ctx);
    }

    @Override
    public Void visitConditionClause(@NotNull FdbScriptParser.ConditionClauseContext ctx) {
        return super.visitConditionClause(ctx);
    }

    @Override
    public Void visitElseClause(@NotNull FdbScriptParser.ElseClauseContext ctx) {
        return super.visitElseClause(ctx);
    }

    @Override
    public Void visitExpression(@NotNull FdbScriptParser.ExpressionContext ctx) {
        return super.visitExpression(ctx);
    }

    @Override
    public Void visitComputedExpression(@NotNull FdbScriptParser.ComputedExpressionContext ctx) {
        return super.visitComputedExpression(ctx);
    }

    @Override
    public Void visitBooleanExpression(@NotNull FdbScriptParser.BooleanExpressionContext ctx) {
        return super.visitBooleanExpression(ctx);
    }

    @Override
    public Void visitEqualityExpression(@NotNull FdbScriptParser.EqualityExpressionContext ctx) {
        return super.visitEqualityExpression(ctx);
    }

    @Override
    public Void visitEqualityOperand(@NotNull FdbScriptParser.EqualityOperandContext ctx) {
        return super.visitEqualityOperand(ctx);
    }

    @Override
    public Void visitCompareExpression(@NotNull FdbScriptParser.CompareExpressionContext ctx) {
        return super.visitCompareExpression(ctx);
    }

    @Override
    public Void visitMathExpression(@NotNull FdbScriptParser.MathExpressionContext ctx) {
        return super.visitMathExpression(ctx);
    }

    @Override
    public Void visitStringExpression(@NotNull FdbScriptParser.StringExpressionContext ctx) {
        return super.visitStringExpression(ctx);
    }
}
