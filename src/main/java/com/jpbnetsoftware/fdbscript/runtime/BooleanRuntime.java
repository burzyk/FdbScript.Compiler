package com.jpbnetsoftware.fdbscript.runtime;

/**
 * Created by pawel on 07/04/15.
 */
public class BooleanRuntime {

    public static Object and(Object lhs, Object rhs) {
        return (Boolean) lhs && (Boolean) rhs;
    }

    public static Object or(Object lhs, Object rhs) {
        return (Boolean) lhs || (Boolean) rhs;
    }
}
