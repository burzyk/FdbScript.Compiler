package com.jpbnetsoftware.fdbscript.runtime.impl;

import com.jpbnetsoftware.fdbscript.runtime.IMathRuntime;

import java.util.DoubleSummaryStatistics;

/**
 * Created by pawel on 07/04/15.
 */
public class JvmMathRuntime implements IMathRuntime {

    @Override
    public Object add(Object lhs, Object rhs) {
        return (Double)lhs + (Double)rhs;
    }

    @Override
    public Object sub(Object lhs, Object rhs) {
        return (Double)lhs - (Double)rhs;
    }

    @Override
    public Object mul(Object lhs, Object rhs) {
        return (Double)lhs * (Double)rhs;
    }

    @Override
    public Object div(Object lhs, Object rhs) {
        return (Double)lhs / (Double)rhs;
    }
}
