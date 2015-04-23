package com.jpbnetsoftware.fdbscript.runtime;

import java.util.Objects;

/**
 * Created by pawel on 22/04/15.
 */
public class RuntimeList {

    private Object[] internalList;

    private RuntimeList(Object[] items) {
        this.internalList = items;
    }

    public static RuntimeList create(Object[] items) {
        return new RuntimeList(items);
    }

    public static RuntimeList concat(RuntimeList a, RuntimeList b) {
        Object[] aList = a.getList();
        Object[] bList = b.getList();
        Object[] result = new Object[aList.length + bList.length];

        System.arraycopy(aList, 0, result, 0, aList.length);
        System.arraycopy(bList, 0, result, aList.length, bList.length);

        return RuntimeList.create(result);
    }

    public Object[] getList() {
        return this.internalList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;

        sb.append("[ ");

        for (Object o : this.internalList) {
            sb.append(o);
            sb.append(++i == this.internalList.length ? "" : ", ");
        }

        sb.append(" ]");

        return sb.toString();
    }
}
