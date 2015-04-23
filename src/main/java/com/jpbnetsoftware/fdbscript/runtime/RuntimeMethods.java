package com.jpbnetsoftware.fdbscript.runtime;

import com.jpbnetsoftware.fdbscript.compiler.generator.impl.BooleanCodeBlock;

import java.util.DoubleSummaryStatistics;

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

        if (lhs instanceof RuntimeList && rhs instanceof RuntimeList) {
            Object[] aList = ((RuntimeList) lhs).getList();
            Object[] bList = ((RuntimeList) rhs).getList();

            if (aList.length != bList.length) {
                return new Boolean(false);
            } else {
                Boolean allEqual = true;

                for (int i = 0; i < aList.length && allEqual; i++) {
                    allEqual = allEqual && (Boolean) isEqual(aList[i], bList[i]);
                }

                return allEqual;
            }
        }

        return lhs.equals(rhs);
    }

    public static Object isNotEqual(Object lhs, Object rhs) {
        return Boolean.valueOf(!(Boolean) isEqual(lhs, rhs));
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

        InvokeContext context = InvokeContext.createChildContext(parentContext);
        String[] arguments = func.getArguments();
        int i = 0;

        for (Object arg : args) {
            context.defineValue(arguments[i++], arg);
        }

        context.defineValue("self", func);

        return func.invoke(context);
    }

    public static Object index(Object listObject, Object first, Object second, boolean singleElementAccess) {
        RuntimeList list = (RuntimeList) listObject;
        int begin = first != null ? (int) ((Double) first).doubleValue() : 0;
        int end = second != null ? (int) ((Double) second).doubleValue() : list.getList().length;

        if (singleElementAccess) {
            return list.getList()[begin];
        } else {
            Object[] sub = new Object[end - begin];
            Object[] l = list.getList();

            for (int i = begin; i < end; i++) {
                sub[i - begin] = l[i];
            }

            return RuntimeList.create(sub);
        }
    }

    public static Object createList(Object[] initValues) {
        return RuntimeList.create(initValues);
    }
}
