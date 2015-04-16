package com.jpbnetsoftware.fdbscript.runtime.objects;

import com.jpbnetsoftware.fdbscript.runtime.interfaces.compare.IEquality;

/**
 * Created by pawel on 15/04/15.
 */
public class RuntimeBoolean extends RuntimeObject implements IEquality {

    private boolean value;

    public static RuntimeBoolean create(boolean value) {
        return new RuntimeBoolean(value);
    }

    private RuntimeBoolean(boolean value) {
        this.value = value;
    }

    @Override
    public RuntimeBoolean isEqual(RuntimeObject other) {
        return RuntimeBoolean.create(this.value == ((RuntimeBoolean) other).value);
    }

    @Override
    public RuntimeBoolean isNotEqual(RuntimeObject other) {
        return RuntimeBoolean.create(this.value != ((RuntimeBoolean) other).value);
    }

    public boolean getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return Boolean.toString(this.value);
    }
}
