package com.jpbnetsoftware.fdbscript.runtime;

import com.jpbnetsoftware.fdbscript.runtime.objects.RuntimeList;
import com.jpbnetsoftware.fdbscript.runtime.objects.RuntimeObject;

/**
 * Created by pawel on 14/04/15.
 */
public class RuntimeMethods {

    public static Object createNumber(double value) {
        return Double.valueOf(value);
    }

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

    public static Object listConcat(Object lhs, Object rhs) {

        RuntimeList aList = lhs instanceof RuntimeList ? (RuntimeList) lhs : RuntimeList.create(new Object[]{lhs});
        RuntimeList bList = rhs instanceof RuntimeList ? (RuntimeList) rhs : RuntimeList.create(new Object[]{rhs});

        return RuntimeList.concat(aList, bList);
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

    public static Object invoke(InvokeContext parentContext, IInvokable function, Object[] args) {

        if (function == null) {
            // TODO: throw runtime exception
        }

        InvokeContext context = InvokeContext.createChildContext(parentContext);
        String[] arguments = function.getArguments();
        int i = 0;

        for (Object arg : args) {
            context.defineValue(arguments[i++], arg);
        }

        context.defineValue("self", function);

        return function.invoke(context);
    }

    public static Object index(RuntimeList list, Object first, Object second, Boolean singleElementAccess) {
        int begin = first != null ? (int) ((Double) first).doubleValue() : 0;
        int end = second != null ? (int) ((Double) second).doubleValue() : list.getLength();

        if (singleElementAccess) {
            return list.getElementAt(begin);
        } else {
            return list.getRange(begin, end);
        }
    }

    public static Object createList(Object[] initValues) {
        return RuntimeList.create(initValues);
    }

    public static Object createObject() {
        return new RuntimeObject();
    }

    public static Object extendObject(RuntimeObject object, String key, Object value) {
        object.defineValue(key, value);

        return object;
    }

    public static Object defineValue(InvokeContext context, String name, Object value) {
        return context.defineValue(name, value);
    }

    public static Object getValue(InvokeContext context, String name) {
        return context.getValue(name);
    }

    public static Object accessMember(RuntimeObject object, String key) {
        return object.getValue(key);
    }
}
