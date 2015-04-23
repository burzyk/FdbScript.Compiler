package com.jpbnetsoftware.fdbscript.compiler.tests;

import com.jpbnetsoftware.fdbscript.compiler.tests.helpers.CompilerHelper;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by pawel on 23/04/15.
 */
public class ListFunctionsTests {

    @Test
    public void generateSimpleTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "x1 = range(0, 4) " +
                "x1 == [0, 1, 2, 3]");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void mapIndexSimpleTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "x1 = range(10, 20) " +
                "x2 = map(x1, f(e, i): i + 11 )" +
                "x2 == [11, 12, 13, 14, 15, 16, 17, 18, 19, 20]");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void mapElementSimpleTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "x1 = range(10, 20) " +
                "x2 = map(x1, f(e, i): e + 10 )" +
                "x2 == [20, 21, 22, 23, 24, 25, 26, 27, 28, 29]");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void filterIndexSimpleTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "x1 = range(10, 20) " +
                "x2 = filter(x1, f(e, i): 5 < i )" +
                "x2 == [16, 17, 18, 19]");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void filterElementSimpleTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "x1 = range(10, 20) " +
                "x2 = filter(x1, f(e, i): 13 < e and e < 16  )" +
                "x2 == [14, 15]");

        Assert.assertEquals(new Boolean(true), result);
    }
}
