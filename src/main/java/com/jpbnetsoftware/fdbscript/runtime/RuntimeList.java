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
