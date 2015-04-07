package com.jpbnetsoftware.fdbscript.runtime;

import java.util.Objects;

/**
 * Created by pawel on 07/04/15.
 */
public class StringRuntime {

    public static Object concat(Object lhs, Object rhs) {
        StringBuilder sb = new StringBuilder();

        sb.append(lhs);
        sb.append(rhs);

        return sb.toString();
    }
}
