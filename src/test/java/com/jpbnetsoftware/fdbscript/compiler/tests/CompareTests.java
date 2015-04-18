package com.jpbnetsoftware.fdbscript.compiler.tests;

import com.jpbnetsoftware.fdbscript.compiler.tests.helpers.CompilerHelper;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by pawel on 14/04/15.
 */
public class CompareTests {

    @Test
    public void simpleNumberTest1() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 3 > 4");

        Assert.assertEquals(new Boolean(false), result);
    }

    @Test
    public void simpleNumberTest2() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 4 > 3");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void simpleNumberTest3() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 3 < 4");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void simpleNumberTest4() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 4 < 3");

        Assert.assertEquals(new Boolean(false), result);
    }

    @Test
    public void simpleNumberTest5() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 3 >= 4");

        Assert.assertEquals(new Boolean(false), result);
    }

    @Test
    public void simpleNumberTest6() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 4 >= 3");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void simpleNumberTest7() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 3 <= 4");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void simpleNumberTest8() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 4 <= 3");

        Assert.assertEquals(new Boolean(false), result);
    }

    @Test
    public void simpleNumberTest9() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 4 <= 4");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void simpleNumberTest10() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 4 >= 4");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void simpleNumberTest11() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 4 == 4");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void simpleNumberTest12() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 4 != 4");

        Assert.assertEquals(new Boolean(false), result);
    }

    @Test
    public void simpleNumberTest13() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 4 != 3");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void mathCompareTest1() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 2 + 2 * 2 > (2 + 2) * 2");

        Assert.assertEquals(new Boolean(false), result);
    }

    @Test
    public void mathCompareTest2() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 2 + 2 * 2 < (2 + 2) * 2");

        Assert.assertEquals(new Boolean(true), result);
    }
}
