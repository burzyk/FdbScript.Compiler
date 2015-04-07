package com.jpbnetsoftware.fdbscript.runtime;

import com.jpbnetsoftware.fdbscript.runtime.impl.JvmMathRuntime;

/**
 * Created by pawel on 07/04/15.
 */
public class RuntimeManager {

    private static IMathRuntime math = new JvmMathRuntime();

    public static IMathRuntime getMathRuntime() {
        return RuntimeManager.math;
    }
}
