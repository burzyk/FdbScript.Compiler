// Generated from /Users/pawel/work/java/FdbScriptCompiler/src/main/antlr/FdbScript.g4 by ANTLR 4.5
package com.jpbnetsoftware.fdbscriptcompiler.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FdbScriptParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FdbScriptVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FdbScriptParser#programDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramDeclaration(@NotNull FdbScriptParser.ProgramDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FdbScriptParser#definitionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinitionExpression(@NotNull FdbScriptParser.DefinitionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FdbScriptParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(@NotNull FdbScriptParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FdbScriptParser#invokeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvokeExpression(@NotNull FdbScriptParser.InvokeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FdbScriptParser#ifExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExpression(@NotNull FdbScriptParser.IfExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FdbScriptParser#conditionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionClause(@NotNull FdbScriptParser.ConditionClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link FdbScriptParser#elseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseClause(@NotNull FdbScriptParser.ElseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link FdbScriptParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull FdbScriptParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FdbScriptParser#computedExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComputedExpression(@NotNull FdbScriptParser.ComputedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FdbScriptParser#booleanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpression(@NotNull FdbScriptParser.BooleanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FdbScriptParser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(@NotNull FdbScriptParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FdbScriptParser#equalityOperand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityOperand(@NotNull FdbScriptParser.EqualityOperandContext ctx);
	/**
	 * Visit a parse tree produced by {@link FdbScriptParser#compareExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareExpression(@NotNull FdbScriptParser.CompareExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FdbScriptParser#mathExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMathExpression(@NotNull FdbScriptParser.MathExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FdbScriptParser#stringExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpression(@NotNull FdbScriptParser.StringExpressionContext ctx);
}