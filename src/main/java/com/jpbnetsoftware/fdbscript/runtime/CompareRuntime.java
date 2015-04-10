package com.jpbnetsoftware.fdbscript.runtime;

/**
 * Created by pawel on 07/04/15.
 */
public class CompareRuntime {

    public static Object greaterThan(Object lhs, Object rhs) {
        return (Double) lhs > (Double) rhs;
    }

    public static Object greaterEqual(Object lhs, Object rhs) {
        return (Double) lhs >= (Double) rhs;
    }

    public static Object lessThan(Object lhs, Object rhs) {
        return (Double) lhs < (Double) rhs;
    }

    public static Object lessEqual(Object lhs, Object rhs) {
        return (Double) lhs <= (Double) rhs;
    }

    public static Object isEqual(Object lhs, Object rhs) {
        return lhs.equals(rhs);
    }

    public static Object isNotEqual(Object lhs, Object rhs) {
        return !lhs.equals(rhs);
    }
}
