package uk.co.directline.mathcompiler;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import uk.co.directline.mathcompiler.antlr.CalcBaseVisitor;
import uk.co.directline.mathcompiler.antlr.CalcParser;
import uk.co.directline.mathcompiler.antlr.CalcVisitor;
import uk.co.directline.mathcompiler.operations.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pawel on 30/03/15.
 */
public class CalcEmitVisitor extends CalcBaseVisitor<Void> {

    ArrayList<BaseOperation> operations;

    public CalcEmitVisitor() {
        this.operations = new ArrayList<BaseOperation>();
    }

    public List<BaseOperation> getOperations() {
        return this.operations;
    }

    @Override
    public Void visitCmd(@NotNull CalcParser.CmdContext ctx) {
        return super.visitCmd(ctx);
    }

    @Override
    public Void visitExpr(@NotNull CalcParser.ExprContext ctx) {


        int value = 0;

        if (ctx.NUMBER() != null) {
            value = Integer.parseInt(ctx.NUMBER().toString());
        }

        emitIfNotNull(ctx.NUMBER(), new LoadValueOperaiton(value));
        emitIfNotNull(ctx.PLUS(), new PlusOperation());
        emitIfNotNull(ctx.MINUS(), new MinusOperation());
        emitIfNotNull(ctx.DIV(), new DivOperation());
        emitIfNotNull(ctx.MUL(), new MulOperation());

        return super.visitExpr(ctx);

    }

    private void emitIfNotNull(Object o, BaseOperation operation) {
        if (o != null) {
            this.operations.add(0, operation);
        }
    }



}
