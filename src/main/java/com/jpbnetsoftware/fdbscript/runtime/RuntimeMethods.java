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

        if (lhs instanceof String || rhs instanceof String) {
            StringBuilder sb = new StringBuilder();

            sb.append(lhs);
            sb.append(rhs);

            return sb.toString();
        }

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

    public static Object invoke(InvokeContext parentContext, String functionName, Object[] args) {
        IInvokable func = (IInvokable) parentContext.getValue(functionName);

        if (func == null) {
            // TODO: throw runtime exception
        }

        InvokeContext context = new InvokeContext(parentContext);
        String[] arguments = func.getArguments();
        int i = 0;

        for (Object arg : args) {
            context.defineValue(arguments[i++], arg);
        }

        context.defineValue("self", func);

        return func.invoke(context);
    }
}
