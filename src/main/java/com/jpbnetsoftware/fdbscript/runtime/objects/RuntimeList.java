package com.jpbnetsoftware.fdbscript.runtime.objects;

import java.util.Iterator;

/**
 * Created by pawel on 22/04/15.
 */
public class RuntimeList implements Iterable {

    private Object[] internalList;

    private RuntimeList(Object[] items) {
        this.internalList = items;
    }

    public static RuntimeList create(Object[] items) {
        return new RuntimeList(items);
    }

    public static RuntimeList concat(RuntimeList a, RuntimeList b) {
        Object[] aList = a.internalList;
        Object[] bList = b.internalList;
        Object[] result = new Object[aList.length + bList.length];

        System.arraycopy(aList, 0, result, 0, aList.length);
        System.arraycopy(bList, 0, result, aList.length, bList.length);

        return RuntimeList.create(result);
    }

    public Object getElementAt(int index) {
        return this.internalList[index];
    }

    public int getLength() {
        return this.internalList.length;
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

    public RuntimeList getRange(int begin, int end) {
        Object[] sub = new Object[end - begin];

        for (int i = begin; i < end; i++) {
            sub[i - begin] = this.internalList[i];
        }

        return RuntimeList.create(sub);
    }

    @Override
    public boolean equals(Object second) {

        if (!(second instanceof RuntimeList)) {
            return false;
        }

        RuntimeList aList = this;
        RuntimeList bList = (RuntimeList) second;

        if (aList.getLength() != bList.getLength()) {
            return false;
        } else {
            Iterator i = aList.iterator();
            Iterator j = bList.iterator();
            Boolean allEqual = true;

            while (i.hasNext() && j.hasNext() && allEqual) {
                allEqual = allEqual && i.next().equals(j.next());
            }

            return allEqual;
        }
    }
}
