package com.jpbnetsoftware.fdbscript.runtime;

/**
 * Created by pawel on 07/04/15.
 */
public class MathRuntime {

    public static Object add(Object lhs, Object rhs) {
        return (Double) lhs + (Double) rhs;
    }

    public static Object sub(Object lhs, Object rhs) {
        return (Double) lhs - (Double) rhs;
    }

    public static Object mul(Object lhs, Object rhs) {
        return (Double) lhs * (Double) rhs;
    }

    public static Object div(Object lhs, Object rhs) {
        return (Double) lhs / (Double) rhs;
    }
}
