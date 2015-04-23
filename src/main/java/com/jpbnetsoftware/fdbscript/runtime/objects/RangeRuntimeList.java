package com.jpbnetsoftware.fdbscript.runtime.objects;

import java.util.Iterator;

/**
 * Created by pawel on 23/04/15.
 */
public class RangeRuntimeList extends RuntimeList {

    private int start;

    private int stop;

    public RangeRuntimeList(int start, int stop) {
        this.start = start;
        this.stop = stop;
    }

    @Override
    public Object getElementAt(int index) {
        return this.start + index;
    }

    @Override
    public int getLength() {
        return this.stop - this.start;
    }

    @Override
    public RuntimeList getRange(int begin, int end) {
        return new RangeRuntimeList(this.start + begin, this.start + end);
    }

    @Override
    public Iterator iterator() {
        final double begin = this.start;
        final double end = this.stop;

        return new Iterator() {

            private double i = begin;

            @Override
            public boolean hasNext() {
                return i < end;
            }

            @Override
            public Object next() {
                return i++;
            }
        };
    }
}
