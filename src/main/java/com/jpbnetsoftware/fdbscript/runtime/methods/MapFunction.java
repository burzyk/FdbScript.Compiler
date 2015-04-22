package com.jpbnetsoftware.fdbscript.runtime.methods;

import com.jpbnetsoftware.fdbscript.runtime.IInvokable;
import com.jpbnetsoftware.fdbscript.runtime.InvokeContext;
import com.jpbnetsoftware.fdbscript.runtime.RuntimeList;

/**
 * Created by pawel on 22/04/15.
 */
public class MapFunction implements IInvokable {

    @Override
    public Object invoke(InvokeContext context) {
        RuntimeList list = (RuntimeList) context.getValue("list");
        IInvokable func = (IInvokable) context.getValue("mapper");

        Object[] mapped = new Object[list.getList().length];

        for (int i = 0; i < list.getList().length; i++) {
            InvokeContext ctx = InvokeContext.createChildContext(context);

            ctx.defineValue("$e", list.getList()[i]);
            ctx.defineValue("$i", i);

            mapped[i] = func.invoke(ctx);
        }

        return RuntimeList.create(mapped);
    }

    @Override
    public String[] getArguments() {
        return new String[]{"list", "mapper"};
    }
}