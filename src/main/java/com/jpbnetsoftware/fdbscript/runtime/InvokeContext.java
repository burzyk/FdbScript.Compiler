package com.jpbnetsoftware.fdbscript.runtime;

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

    public static InvokeContext createRootScope() {
        return new InvokeContext(null);
    }

    public static InvokeContext createChildScope(InvokeContext parent) {
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
