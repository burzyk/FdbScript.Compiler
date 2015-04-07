package com.jpbnetsoftware.fdbscript.runtime;

/**
 * Created by pawel on 07/04/15.
 */
public interface IMathRuntime {

    Object add(Object lhs, Object rhs);

    Object sub(Object lhs, Object rhs);

    Object mul(Object lhs, Object rhs);

    Object div(Object lhs, Object rhs);
}
