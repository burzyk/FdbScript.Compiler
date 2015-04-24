package com.jpbnetsoftware.fdbscript.runtime.methods;

import com.jpbnetsoftware.fdbscript.runtime.IInvokable;
import com.jpbnetsoftware.fdbscript.runtime.InvokeContext;
import com.jpbnetsoftware.fdbscript.runtime.objects.RuntimeList;

/**
 * Created by pawel on 24/04/15.
 */
public class ReduceFunction implements IInvokable {

    @Override
    public Object invoke(InvokeContext context) {
        RuntimeList list = (RuntimeList) context.getValue("list");
        IInvokable func = (IInvokable) context.getValue("reducer");
        Object acc = context.getValue("initial");
        String[] funcArguments = func.getArguments();
        int i = 0;

        for (Object item : list) {
            InvokeContext ctx = InvokeContext.createChildContext(context);

            ctx.defineValue(funcArguments.length <= 0 ? "$acc" : funcArguments[0], acc);
            ctx.defineValue(funcArguments.length <= 1 ? "$e" : funcArguments[1], item);
            ctx.defineValue(funcArguments.length <= 2 ? "$l" : funcArguments[2], list);
            ctx.defineValue(funcArguments.length <= 3 ? "$i" : funcArguments[3], (double) i);

            acc = func.invoke(ctx);
            i++;
        }

        return acc;
    }

    @Override
    public String[] getArguments() {
        return new String[]{"list", "initial", "reducer"};
    }
}