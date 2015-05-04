// Generated from /Users/pawel/work/java/FdbScriptCompiler/src/main/antlr/FdbScript.g4 by ANTLR 4.5
package com.jpbnetsoftware.fdbscript.compiler.antlr;
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
	 * Enter a parse tree produced by {@link FdbScriptParser#definitionExpression}.
	 * @param ctx the parse tree
	 */
	void enterDefinitionExpression(@NotNull FdbScriptParser.DefinitionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FdbScriptParser#definitionExpression}.
	 * @param ctx the parse tree
	 */
	void exitDefinitionExpression(@NotNull FdbScriptParser.DefinitionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FdbScriptParser#definitionInvokeExpression}.
	 * @param ctx the parse tree
	 */
	void enterDefinitionInvokeExpression(@NotNull FdbScriptParser.DefinitionInvokeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FdbScriptParser#definitionInvokeExpression}.
	 * @param ctx the parse tree
	 */
	void exitDefinitionInvokeExpression(@NotNull FdbScriptParser.DefinitionInvokeExpressionContext ctx);
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
	 * Enter a parse tree produced by {@link FdbScriptParser#listExpression}.
	 * @param ctx the parse tree
	 */
	void enterListExpression(@NotNull FdbScriptParser.ListExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FdbScriptParser#listExpression}.
	 * @param ctx the parse tree
	 */
	void exitListExpression(@NotNull FdbScriptParser.ListExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FdbScriptParser#indexExpression}.
	 * @param ctx the parse tree
	 */
	void enterIndexExpression(@NotNull FdbScriptParser.IndexExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FdbScriptParser#indexExpression}.
	 * @param ctx the parse tree
	 */
	void exitIndexExpression(@NotNull FdbScriptParser.IndexExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FdbScriptParser#listAccessArgExpression}.
	 * @param ctx the parse tree
	 */
	void enterListAccessArgExpression(@NotNull FdbScriptParser.ListAccessArgExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FdbScriptParser#listAccessArgExpression}.
	 * @param ctx the parse tree
	 */
	void exitListAccessArgExpression(@NotNull FdbScriptParser.ListAccessArgExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FdbScriptParser#listAccessExpression}.
	 * @param ctx the parse tree
	 */
	void enterListAccessExpression(@NotNull FdbScriptParser.ListAccessExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FdbScriptParser#listAccessExpression}.
	 * @param ctx the parse tree
	 */
	void exitListAccessExpression(@NotNull FdbScriptParser.ListAccessExpressionContext ctx);
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
	 * Enter a parse tree produced by {@link FdbScriptParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void enterValueExpression(@NotNull FdbScriptParser.ValueExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FdbScriptParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void exitValueExpression(@NotNull FdbScriptParser.ValueExpressionContext ctx);
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
	 * Enter a parse tree produced by {@link FdbScriptParser#listConcatExpression}.
	 * @param ctx the parse tree
	 */
	void enterListConcatExpression(@NotNull FdbScriptParser.ListConcatExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FdbScriptParser#listConcatExpression}.
	 * @param ctx the parse tree
	 */
	void exitListConcatExpression(@NotNull FdbScriptParser.ListConcatExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FdbScriptParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(@NotNull FdbScriptParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FdbScriptParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(@NotNull FdbScriptParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FdbScriptParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(@NotNull FdbScriptParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FdbScriptParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(@NotNull FdbScriptParser.MultiplicativeExpressionContext ctx);
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
	 * Enter a parse tree produced by {@link FdbScriptParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpression(@NotNull FdbScriptParser.LogicalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FdbScriptParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpression(@NotNull FdbScriptParser.LogicalExpressionContext ctx);
}