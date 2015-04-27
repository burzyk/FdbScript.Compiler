package com.jpbnetsoftware.fdbscript.runtime.methods;

import com.jpbnetsoftware.fdbscript.runtime.IInvokable;
import com.jpbnetsoftware.fdbscript.runtime.InvokeContext;
import com.jpbnetsoftware.fdbscript.runtime.RuntimeMethods;
import com.jpbnetsoftware.fdbscript.runtime.objects.RuntimeList;

/**
 * Created by pawel on 27/04/15.
 */
public class LengthFunction implements IInvokable {

    @Override
    public Object invoke(InvokeContext context) {
        RuntimeList list = (RuntimeList) context.getValue("list");

        return RuntimeMethods.createNumber(list.getLength());
    }

    @Override
    public String[] getArguments() {
        return new String[]{"list"};
    }
}