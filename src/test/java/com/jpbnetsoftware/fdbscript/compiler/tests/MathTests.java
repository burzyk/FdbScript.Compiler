package com.jpbnetsoftware.fdbscript.compiler.tests;

import com.jpbnetsoftware.fdbscript.compiler.tests.helpers.CompilerHelper;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by pawel on 05/04/15.
 */
public class MathTests {

    @Test
    public void simpleNumberTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 10");

        Assert.assertEquals(new Double(10), result);
    }

    @Test
    public void addSimpleTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 2 + 2");

        Assert.assertEquals(new Double(4), result);
    }

    @Test
    public void addMultipleTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 2 + 2 + 100");

        Assert.assertEquals(new Double(104), result);
    }

    @Test
    public void subSimpleTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 10 - 8");

        Assert.assertEquals(new Double(2), result);
    }

    @Test
    public void subMultipleTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 10 - 8 - 12");

        Assert.assertEquals(new Double(-10), result);
    }

    @Test
    public void mulSimpleTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 2 * 6");

        Assert.assertEquals(new Double(12), result);
    }

    @Test
    public void mulMultipleTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 2 * 2 * 7");

        Assert.assertEquals(new Double(28), result);
    }

    @Test
    public void divSimpleTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 7 / 2");

        Assert.assertEquals(new Double(3.5), result);
    }

    @Test
    public void divMultipleTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 12 / 3 / 2");

        Assert.assertEquals(new Double(2), result);
    }

    @Test
    public void priorityTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 2 + 2 * 2");

        Assert.assertEquals(new Double(6), result);
    }

    @Test
    public void bracketsTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test (2 + 2) * 2");

        Assert.assertEquals(new Double(8), result);
    }

    @Test
    public void combination1Test() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test (2 + 2) * 2 / 2 - 2 + 10 * 99");

        Assert.assertEquals(new Double(992), result);
    }

    @Test
    public void combination2Test() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test (2 + 2) * 2 / 2 - 2 + 10");

        Assert.assertEquals(new Double(12), result);
    }

    @Test
    public void combination3Test() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 2 - 2 + 10");

        Assert.assertEquals(new Double(10), result);
    }

    @Test
    public void combination4Test() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 2 / 2 * 10");

        Assert.assertEquals(new Double(10), result);
    }

    @Test
    public void combination5Test() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test (2 / 2) * 10");

        Assert.assertEquals(new Double(10), result);
    }
}
