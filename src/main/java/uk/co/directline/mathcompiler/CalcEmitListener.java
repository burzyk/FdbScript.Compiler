package uk.co.directline.mathcompiler;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import uk.co.directline.mathcompiler.antlr.CalcListener;
import uk.co.directline.mathcompiler.antlr.CalcParser;
import uk.co.directline.mathcompiler.operations.BaseOperation;

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
        int w = 0;

    }

    @Override
    public void exitExpr(@NotNull CalcParser.ExprContext ctx) {
        int w = 0;
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
