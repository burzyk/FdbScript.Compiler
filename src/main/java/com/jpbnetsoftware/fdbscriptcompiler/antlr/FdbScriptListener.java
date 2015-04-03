// Generated from /Users/pawel/work/java/FdbScriptCompiler/src/main/antlr/FdbScript.g4 by ANTLR 4.5
package com.jpbnetsoftware.fdbscriptcompiler.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FdbScriptParser}.
 */
public interface FdbScriptListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FdbScriptParser#programDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterProgramDeclaration(@NotNull FdbScriptParser.ProgramDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link FdbScriptParser#programDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitProgramDeclaration(@NotNull FdbScriptParser.ProgramDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link FdbScriptParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(@NotNull FdbScriptParser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FdbScriptParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(@NotNull FdbScriptParser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FdbScriptParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(@NotNull FdbScriptParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link FdbScriptParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(@NotNull FdbScriptParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link FdbScriptParser#invokeExpression}.
	 * @param ctx the parse tree
	 */
	void enterInvokeExpression(@NotNull FdbScriptParser.InvokeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FdbScriptParser#invokeExpression}.
	 * @param ctx the parse tree
	 */
	void exitInvokeExpression(@NotNull FdbScriptParser.InvokeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FdbScriptParser#ifExpression}.
	 * @param ctx the parse tree
	 */
	void enterIfExpression(@NotNull FdbScriptParser.IfExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FdbScriptParser#ifExpression}.
	 * @param ctx the parse tree
	 */
	void exitIfExpression(@NotNull FdbScriptParser.IfExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FdbScriptParser#conditionClause}.
	 * @param ctx the parse tree
	 */
	void enterConditionClause(@NotNull FdbScriptParser.ConditionClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link FdbScriptParser#conditionClause}.
	 * @param ctx the parse tree
	 */
	void exitConditionClause(@NotNull FdbScriptParser.ConditionClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link FdbScriptParser#elseClause}.
	 * @param ctx the parse tree
	 */
	void enterElseClause(@NotNull FdbScriptParser.ElseClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link FdbScriptParser#elseClause}.
	 * @param ctx the parse tree
	 */
	void exitElseClause(@NotNull FdbScriptParser.ElseClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link FdbScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull FdbScriptParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FdbScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull FdbScriptParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FdbScriptParser#computedExpression}.
	 * @param ctx the parse tree
	 */
	void enterComputedExpression(@NotNull FdbScriptParser.ComputedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FdbScriptParser#computedExpression}.
	 * @param ctx the parse tree
	 */
	void exitComputedExpression(@NotNull FdbScriptParser.ComputedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FdbScriptParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExpression(@NotNull FdbScriptParser.BooleanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FdbScriptParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExpression(@NotNull FdbScriptParser.BooleanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FdbScriptParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(@NotNull FdbScriptParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FdbScriptParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(@NotNull FdbScriptParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FdbScriptParser#equalityOperand}.
	 * @param ctx the parse tree
	 */
	void enterEqualityOperand(@NotNull FdbScriptParser.EqualityOperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link FdbScriptParser#equalityOperand}.
	 * @param ctx the parse tree
	 */
	void exitEqualityOperand(@NotNull FdbScriptParser.EqualityOperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link FdbScriptParser#compareExpression}.
	 * @param ctx the parse tree
	 */
	void enterCompareExpression(@NotNull FdbScriptParser.CompareExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FdbScriptParser#compareExpression}.
	 * @param ctx the parse tree
	 */
	void exitCompareExpression(@NotNull FdbScriptParser.CompareExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FdbScriptParser#mathExpression}.
	 * @param ctx the parse tree
	 */
	void enterMathExpression(@NotNull FdbScriptParser.MathExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FdbScriptParser#mathExpression}.
	 * @param ctx the parse tree
	 */
	void exitMathExpression(@NotNull FdbScriptParser.MathExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FdbScriptParser#stringExpression}.
	 * @param ctx the parse tree
	 */
	void enterStringExpression(@NotNull FdbScriptParser.StringExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FdbScriptParser#stringExpression}.
	 * @param ctx the parse tree
	 */
	void exitStringExpression(@NotNull FdbScriptParser.StringExpressionContext ctx);
}