package com.jpbnetsoftware.fdbscriptcompiler;

import com.jpbnetsoftware.fdbscriptcompiler.antlr.CalcParser;
import com.jpbnetsoftware.fdbscriptcompiler.operations.BaseOperation;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import com.jpbnetsoftware.fdbscriptcompiler.antlr.CalcListener;
import com.jpbnetsoftware.fdbscriptcompiler.operations.LoadValueOperaiton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pawel on 30/03/15.
 */
public class CalcEmitListener implements CalcListener {

    List<BaseOperation> operations;

    public CalcEmitListener() {
        this.operations = new ArrayList<BaseOperation>();
    }

    public List<BaseOperation> getOperations() {
        return this.operations;
    }

    @Override
    public void enterCmd(@NotNull CalcParser.CmdContext ctx) {
    }

    @Override
    public void exitCmd(@NotNull CalcParser.CmdContext ctx) {

    }

    @Override
    public void enterExpr(@NotNull CalcParser.ExprContext ctx) {
        printIfNotNull("enter: ", ctx.NUMBER());
        printIfNotNull("enter: ", ctx.PLUS());
        printIfNotNull("enter: ", ctx.MINUS());
        printIfNotNull("enter: ", ctx.DIV());
        printIfNotNull("enter: ", ctx.MUL());
    }

    @Override
    public void exitExpr(@NotNull CalcParser.ExprContext ctx) {
        if (ctx.NUMBER() != null) {
            this.operations.add(new LoadValueOperaiton(Integer.parseInt(ctx.NUMBER().toString())));


        }




        printIfNotNull("exit: ", ctx.NUMBER());
        printIfNotNull("exit: ", ctx.PLUS());
        printIfNotNull("exit: ", ctx.MINUS());
        printIfNotNull("exit: ", ctx.DIV());
        printIfNotNull("exit: ", ctx.MUL());
    }

    private void printIfNotNull(String state, Object o) {
        if (o != null) {
            System.out.println(state + o);
        }
    }

    @Override
    public void visitTerminal(TerminalNode node) {

    }

    @Override
    public void visitErrorNode(ErrorNode node) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {

    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {

    }
}
