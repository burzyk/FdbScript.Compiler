package com.jpbnetsoftware.fdbscript.runtime.methods;

import com.jpbnetsoftware.fdbscript.runtime.IInvokable;
import com.jpbnetsoftware.fdbscript.runtime.InvokeContext;
import com.jpbnetsoftware.fdbscript.runtime.RuntimeMethods;
import com.jpbnetsoftware.fdbscript.runtime.objects.RuntimeList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pawel on 23/04/15.
 */
public class FilterFunction implements IInvokable {

    @Override
    public Object invoke(InvokeContext context) {
        RuntimeList list = (RuntimeList) context.getValue("list");
        IInvokable predicate = (IInvokable) context.getValue("predicate");
        String[] predicateArguments = predicate.getArguments();
        List<Object> filtered = new ArrayList<Object>();
        int i = 0;

        for (Object item : list) {
            InvokeContext ctx = InvokeContext.createChildContext(context);

            ctx.defineValue(predicateArguments.length <= 0 ? "$e" : predicateArguments[0], item);
            ctx.defineValue(predicateArguments.length <= 1 ? "$i" : predicateArguments[1], (double) i);

            if (RuntimeMethods.isEqual(predicate.invoke(ctx), true) == Boolean.valueOf(true)) {
                filtered.add(item);
            }

            i++;
        }

        return RuntimeList.create(filtered.toArray());
    }

    @Override
    public String[] getArguments() {
        return new String[]{"list", "predicate"};
    }
}
