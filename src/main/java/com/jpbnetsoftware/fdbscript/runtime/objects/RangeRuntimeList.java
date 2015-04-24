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
    public RuntimeList reverse() {
        return new RangeRuntimeList(stop - 1, start - 1);
    }

    @Override
    public Object getElementAt(int index) {
        return this.isReversed()
                ? this.start - index
                : this.start + index;
    }

    @Override
    public int getLength() {
        return Math.abs(this.stop - this.start);
    }

    @Override
    public RuntimeList getRange(int begin, int end) {
        return this.isReversed()
                ? new RangeRuntimeList(this.start - begin, this.start - end)
                : new RangeRuntimeList(this.start + begin, this.start + end);
    }

    @Override
    public Iterator iterator() {
        final double begin = this.start;
        final double end = this.stop;
        final boolean isReversed = this.isReversed();

        return new Iterator() {

            private double i = begin;

            @Override
            public boolean hasNext() {
                return isReversed
                        ? i > end
                        : i < end;
            }

            @Override
            public Object next() {
                double current = i;

                i = isReversed
                        ? i - 1
                        : i + 1;

                return current;
            }
        };
    }

    private boolean isReversed() {
        return this.start > this.stop;
    }
}
