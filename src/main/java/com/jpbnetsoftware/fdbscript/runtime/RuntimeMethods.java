package com.jpbnetsoftware.fdbscript.runtime;

/**
 * Created by pawel on 14/04/15.
 */
public class RuntimeMethods {

    public static Object and(Object lhs, Object rhs) {
        return (Boolean) lhs && (Boolean) rhs;
    }

    public static Object or(Object lhs, Object rhs) {
        return (Boolean) lhs || (Boolean) rhs;
    }

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

    public static Object concat(Object lhs, Object rhs) {
        StringBuilder sb = new StringBuilder();

        sb.append(lhs);
        sb.append(rhs);

        return sb.toString();
    }
}
