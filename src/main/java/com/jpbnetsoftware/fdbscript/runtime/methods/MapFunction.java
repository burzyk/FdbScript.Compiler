package com.jpbnetsoftware.fdbscript.runtime.methods;

import com.jpbnetsoftware.fdbscript.runtime.IInvokable;
import com.jpbnetsoftware.fdbscript.runtime.InvokeContext;
import com.jpbnetsoftware.fdbscript.runtime.RuntimeList;
import com.jpbnetsoftware.fdbscript.runtime.RuntimeMethods;

/**
 * Created by pawel on 22/04/15.
 */
public class MapFunction implements IInvokable {

    @Override
    public Object invoke(InvokeContext context) {
        RuntimeList list = (RuntimeList) context.getValue("list");
        IInvokable func = (IInvokable) context.getValue("mapper");
        String[] funcArguments = func.getArguments();
        Object[] mapped = new Object[list.getList().length];

        for (int i = 0; i < list.getList().length; i++) {
            InvokeContext ctx = InvokeContext.createChildContext(context);

            ctx.defineValue(funcArguments.length == 0 ? "$e" : funcArguments[0], list.getList()[i]);
            ctx.defineValue(funcArguments.length == 1 ? "$i" : funcArguments[1], i);

            mapped[i] = func.invoke(ctx);
        }

        return RuntimeList.create(mapped);
    }

    @Override
    public String[] getArguments() {
        return new String[]{"list", "mapper"};
    }
}