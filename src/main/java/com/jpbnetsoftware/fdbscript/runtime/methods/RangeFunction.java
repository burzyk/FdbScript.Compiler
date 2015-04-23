package com.jpbnetsoftware.fdbscript.runtime.methods;

import com.jpbnetsoftware.fdbscript.runtime.IInvokable;
import com.jpbnetsoftware.fdbscript.runtime.InvokeContext;
import com.jpbnetsoftware.fdbscript.runtime.objects.RuntimeList;

/**
 * Created by pawel on 23/04/15.
 */
public class RangeFunction implements IInvokable {

    @Override
    public Object invoke(InvokeContext context) {
        double begin = (Double) context.getValue("begin");
        double end = (Double) context.getValue("end");

        return RuntimeList.create((int)begin, (int)end);
    }

    @Override
    public String[] getArguments() {
        return new String[]{"begin", "end"};
    }
}