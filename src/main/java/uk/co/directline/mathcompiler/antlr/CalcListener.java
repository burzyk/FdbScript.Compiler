// Generated from /Users/pawel/work/java/MathCompiler/src/main/antlr/Calc.g4 by ANTLR 4.5
package uk.co.directline.mathcompiler.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalcParser}.
 */
public interface CalcListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalcParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(@NotNull CalcParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(@NotNull CalcParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(@NotNull CalcParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(@NotNull CalcParser.ExprContext ctx);
}