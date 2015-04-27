package com.jpbnetsoftware.fdbscript.runtime;

import com.jpbnetsoftware.fdbscript.runtime.methods.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pawel on 14/04/15.
 */
public class InvokeContext {

    private Map<String, Object> locals = new HashMap<String, Object>();

    private InvokeContext parent;

    private InvokeContext(InvokeContext parent) {
        this.parent = parent;
    }

    public static InvokeContext createRootContext() {
        InvokeContext ctx = new InvokeContext(null);

        ctx.defineValue("map", new MapFunction());
        ctx.defineValue("range", new RangeFunction());
        ctx.defineValue("filter", new FilterFunction());
        ctx.defineValue("reverse", new ReverseFunction());
        ctx.defineValue("reduce", new ReduceFunction());
        ctx.defineValue("length", new LengthFunction());
        ctx.defineValue("all", new AllFunction());

        return ctx;
    }

    public static InvokeContext createChildContext(InvokeContext parent) {
        return new InvokeContext(parent);
    }

    public void defineValue(String name, Object value) {
        this.locals.put(name, value);
    }

    public Object getValue(String name) {
        Object value = this.locals.getOrDefault(name, null);
        value = value == null && this.parent != null ? this.parent.getValue(name) : value;

        if (value == null) {
            //TODO: throw no variable defined
        }

        return value;
    }
}
