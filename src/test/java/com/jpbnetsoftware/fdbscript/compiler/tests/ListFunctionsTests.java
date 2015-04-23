package com.jpbnetsoftware.fdbscript.compiler.tests;

import com.jpbnetsoftware.fdbscript.compiler.tests.helpers.CompilerHelper;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by pawel on 23/04/15.
 */
public class ListFunctionsTests {

    @Test
    public void listConcatElementBackTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "x1 = [2, 3, 4] @ 1 " +
                "x2 = [2, 3, 4, 1] " +
                "x1 == x2");

        Assert.assertEquals(new Boolean(true), result);
    }
}
