// Generated from /Users/pawel/work/java/FdbScriptCompiler/src/main/antlr/FdbScript.g4 by ANTLR 4.5
package com.jpbnetsoftware.fdbscript.compiler.antlr;
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
	 * Visit a parse tree produced by {@link FdbScriptParser#definitionInvokeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinitionInvokeExpression(@NotNull FdbScriptParser.DefinitionInvokeExpressionContext ctx);
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
	 * Visit a parse tree produced by {@link FdbScriptParser#listExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListExpression(@NotNull FdbScriptParser.ListExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FdbScriptParser#indexExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexExpression(@NotNull FdbScriptParser.IndexExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FdbScriptParser#objectExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectExpression(@NotNull FdbScriptParser.ObjectExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FdbScriptParser#objectMemberAccessExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectMemberAccessExpression(@NotNull FdbScriptParser.ObjectMemberAccessExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FdbScriptParser#listAccessArgExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListAccessArgExpression(@NotNull FdbScriptParser.ListAccessArgExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FdbScriptParser#listAccessExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListAccessExpression(@NotNull FdbScriptParser.ListAccessExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FdbScriptParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull FdbScriptParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FdbScriptParser#valueExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueExpression(@NotNull FdbScriptParser.ValueExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FdbScriptParser#mathExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMathExpression(@NotNull FdbScriptParser.MathExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FdbScriptParser#listConcatExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListConcatExpression(@NotNull FdbScriptParser.ListConcatExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FdbScriptParser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(@NotNull FdbScriptParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FdbScriptParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(@NotNull FdbScriptParser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FdbScriptParser#compareExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareExpression(@NotNull FdbScriptParser.CompareExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FdbScriptParser#logicalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalExpression(@NotNull FdbScriptParser.LogicalExpressionContext ctx);
}