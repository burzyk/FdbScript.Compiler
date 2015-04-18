package com.jpbnetsoftware.fdbscript.compiler.tests;

import com.jpbnetsoftware.fdbscript.compiler.tests.helpers.CompilerHelper;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by pawel on 18/04/15.
 */
public class FunctionTests {

    @Test
    public void function1Test() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test",
                "module Test " +
                        "add = f(x, y): x + y" +
                        " " +
                        "result = add(1, 1)" +
                        " " +
                        "(result == 2) -> true _ -> false");

        Assert.assertEquals(new Boolean(true), result);
    }
}
