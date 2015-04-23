package com.jpbnetsoftware.fdbscript.runtime.objects;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by pawel on 22/04/15.
 */
public abstract class RuntimeList implements Iterable {

    public static RuntimeList create(Object[] items) {
        return new MaterializedRuntimeList(items);
    }

    public static RuntimeList create(int start, int stop) {
        return new RangeRuntimeList(start, stop);
    }

    public static RuntimeList concat(RuntimeList lhs, RuntimeList rhs) {
        return lhs.concat(rhs);
    }

    public RuntimeList concat(RuntimeList second) {
        Object[] aList = this.materialize();
        Object[] bList = second.materialize();
        Object[] result = new Object[aList.length + bList.length];

        System.arraycopy(aList, 0, result, 0, aList.length);
        System.arraycopy(bList, 0, result, aList.length, bList.length);

        return RuntimeList.create(result);
    }

    public Object getElementAt(int index) {
        Iterator i = this.iterator();
        Object value = null;

        while (i.hasNext() && index-- > 0) {
            value = i.next();
        }
        return value;
    }

    public int getLength() {
        Iterator i = this.iterator();
        int count = 0;

        while (i.hasNext()) {
            count++;
        }

        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;

        sb.append("[ ");

        for (Object o : this) {
            sb.append(o);
            sb.append(++i == this.getLength() ? "" : ", ");
        }

        sb.append(" ]");

        return sb.toString();
    }

    public RuntimeList getRange(int begin, int end) {
        Iterator iterator = this.iterator();
        Object[] sub = new Object[end - begin];
        int i = 0;

        while (i < end && iterator.hasNext()) {
            Object next = iterator.next();

            if (i >= begin) {
                sub[i - begin] = next;
            }

            i++;
        }

        return RuntimeList.create(sub);
    }

    public Object[] materialize() {
        List<Object> list = new ArrayList<Object>();

        for (Object item : this) {
            list.add(item);
        }

        return list.toArray();
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
