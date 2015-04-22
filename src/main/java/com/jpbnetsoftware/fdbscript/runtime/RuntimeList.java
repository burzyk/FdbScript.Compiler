package com.jpbnetsoftware.fdbscript.runtime;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pawel on 22/04/15.
 */
public class RuntimeList {

    private Object[] internalList;

    private RuntimeList(Object[] items) {
        this.internalList = items;
    }

    public static Object create(Object[] items) {
        return new RuntimeList(items);
    }

    public Object[] getList() {
        return this.internalList;
    }
}
