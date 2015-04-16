package com.jpbnetsoftware.fdbscript.runtime.objects;

import com.jpbnetsoftware.fdbscript.runtime.interfaces.compare.IEquality;
import com.jpbnetsoftware.fdbscript.runtime.interfaces.math.IAdd;

/**
 * Created by pawel on 15/04/15.
 */
public class RuntimeString extends RuntimeObject implements IEquality, IAdd {

    private String value;

    public static RuntimeString create(String value) {
        return new RuntimeString(value);
    }

    private RuntimeString(String value) {
        this.value = value;
    }

    @Override
    public RuntimeObject add(RuntimeObject other) {
        StringBuilder sb = new StringBuilder();

        sb.append(this.value);
        sb.append(other);

        return new RuntimeString(sb.toString());
    }

    @Override
    public RuntimeBoolean isEqual(RuntimeObject other) {
        return RuntimeBoolean.create(this.value.equals(((RuntimeString) other).value));
    }

    @Override
    public RuntimeBoolean isNotEqual(RuntimeObject other) {
        return RuntimeBoolean.create(!this.value.equals(((RuntimeString) other).value));
    }

    @Override
    public String toString() {
        return this.value;
    }
}
