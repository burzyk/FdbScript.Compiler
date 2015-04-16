package com.jpbnetsoftware.fdbscript.runtime.objects;

import com.jpbnetsoftware.fdbscript.runtime.interfaces.compare.IEquality;
import com.jpbnetsoftware.fdbscript.runtime.interfaces.compare.IRelation;
import com.jpbnetsoftware.fdbscript.runtime.interfaces.math.IAdd;
import com.jpbnetsoftware.fdbscript.runtime.interfaces.math.IDiv;
import com.jpbnetsoftware.fdbscript.runtime.interfaces.math.IMul;
import com.jpbnetsoftware.fdbscript.runtime.interfaces.math.ISub;

/**
 * Created by pawel on 15/04/15.
 */
public class RuntimeNumber extends RuntimeObject implements IEquality, IRelation, IAdd, ISub, IMul, IDiv {

    private double value;

    public static RuntimeNumber create(double value) {
        return new RuntimeNumber(value);
    }

    private RuntimeNumber(double value) {
        this.value = value;
    }

    @Override
    public RuntimeBoolean isEqual(RuntimeObject other) {
        return RuntimeBoolean.create(this.value == ((RuntimeNumber) other).value);
    }

    @Override
    public RuntimeBoolean isNotEqual(RuntimeObject other) {
        return RuntimeBoolean.create(this.value != ((RuntimeNumber) other).value);
    }

    @Override
    public RuntimeObject add(RuntimeObject other) {

        if (other instanceof RuntimeString) {
            StringBuilder sb = new StringBuilder();

            sb.append(this.value);
            sb.append(other);

            return RuntimeString.create(sb.toString());
        }

        return new RuntimeNumber(this.value + ((RuntimeNumber) other).value);
    }

    @Override
    public RuntimeObject div(RuntimeObject other) {
        return new RuntimeNumber(this.value / ((RuntimeNumber) other).value);
    }

    @Override
    public RuntimeObject mul(RuntimeObject other) {
        return new RuntimeNumber(this.value * ((RuntimeNumber) other).value);
    }

    @Override
    public RuntimeObject sub(RuntimeObject other) {
        return new RuntimeNumber(this.value - ((RuntimeNumber) other).value);
    }

    @Override
    public RuntimeBoolean isGreaterEqual(RuntimeObject other) {
        return RuntimeBoolean.create(this.value >= ((RuntimeNumber) other).value);
    }

    @Override
    public RuntimeBoolean isGreaterThen(RuntimeObject other) {
        return RuntimeBoolean.create(this.value > ((RuntimeNumber) other).value);
    }

    @Override
    public RuntimeBoolean isLessThan(RuntimeObject other) {
        return RuntimeBoolean.create(this.value < ((RuntimeNumber) other).value);
    }

    @Override
    public RuntimeBoolean isLessEqual(RuntimeObject other) {
        return RuntimeBoolean.create(this.value <= ((RuntimeNumber) other).value);
    }

    @Override
    public String toString() {
        return Double.toString(this.value);
    }
}
