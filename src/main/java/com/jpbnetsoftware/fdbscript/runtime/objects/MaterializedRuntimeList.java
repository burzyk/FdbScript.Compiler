package com.jpbnetsoftware.fdbscript.runtime.objects;

import java.util.Iterator;

/**
 * Created by pawel on 23/04/15.
 */
public class MaterializedRuntimeList extends RuntimeList {

    private Object[] internalList;

    public MaterializedRuntimeList(Object[] items) {
        this.internalList = items;
    }

    @Override
    public Iterator iterator() {
        final Object[] list = this.internalList;

        return new Iterator() {

            private int i = 0;

            @Override
            public boolean hasNext() {
                return i < list.length;
            }

            @Override
            public Object next() {
                return list[i++];
            }
        };
    }

    @Override
    public Object getElementAt(int index) {
        return this.internalList[index];
    }

    @Override
    public int getLength() {
        return this.internalList.length;
    }

    @Override
    public RuntimeList getRange(int begin, int end) {
        int count = end - begin;
        Object[] sub = new Object[count];

        System.arraycopy(this.internalList, begin, sub, 0, count);

        return new MaterializedRuntimeList(sub);
    }
}
