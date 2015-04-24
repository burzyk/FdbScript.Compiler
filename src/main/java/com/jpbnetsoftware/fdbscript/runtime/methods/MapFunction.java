package com.jpbnetsoftware.fdbscript.runtime.methods;

import com.jpbnetsoftware.fdbscript.runtime.IInvokable;
import com.jpbnetsoftware.fdbscript.runtime.InvokeContext;
import com.jpbnetsoftware.fdbscript.runtime.objects.RuntimeList;

/**
 * Created by pawel on 22/04/15.
 */
public class MapFunction implements IInvokable {

    @Override
    public Object invoke(InvokeContext context) {
        RuntimeList list = (RuntimeList) context.getValue("list");
        IInvokable func = (IInvokable) context.getValue("mapper");
        String[] funcArguments = func.getArguments();
        Object[] mapped = new Object[list.getLength()];
        int i = 0;

        for (Object item : list) {
            InvokeContext ctx = InvokeContext.createChildContext(context);

            ctx.defineValue(funcArguments.length <= 0 ? "$e" : funcArguments[0], item);
            ctx.defineValue(funcArguments.length <= 1 ? "$i" : funcArguments[1], (double) i);

            mapped[i] = func.invoke(ctx);
            i++;
        }

        return RuntimeList.create(mapped);
    }

    @Override
    public String[] getArguments() {
        return new String[]{"list", "mapper"};
    }
}