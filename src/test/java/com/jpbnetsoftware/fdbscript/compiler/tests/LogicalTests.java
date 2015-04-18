package com.jpbnetsoftware.fdbscript.compiler.tests;

import com.jpbnetsoftware.fdbscript.compiler.tests.helpers.CompilerHelper;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by pawel on 18/04/15.
 */
public class LogicalTests {

    @Test
    public void simpleAnd1Test() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 3 == 3 and 8 == 8");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void simpleAnd2Test() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 3 != 3 and 8 == 8");

        Assert.assertEquals(new Boolean(false), result);
    }

    @Test
    public void simpleOr1Test() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 3 == 3 or 8 == 8");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void simpleOr2Test() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 3 != 3 or 8 == 8");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void simpleOr3Test() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 3 != 3 or 8 != 8");

        Assert.assertEquals(new Boolean(false), result);
    }

    @Test
    public void andOrChain1Test() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 1 == 1 and (8 == 8 or 9 != 9)");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void andOrChain2Test() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test (1 == 1 and 2 == 1) or (1 == 1 and 2 == 2)");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void andOrChain3Test() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test (1 == 8 or 2 == 1) and (1 == 1 or 2 == 2)");

        Assert.assertEquals(new Boolean(false), result);
    }

    @Test
    public void andOrChain4Test() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 1 == 8 or 2 == 1 and 1 == 1 or 2 == 2");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void andOrChain5Test() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test  1 == 1 or 2 == 1 and 2 == 2 ");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void andOrChain6Test() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test (1 > 8 or 2 <= 1) and (1 >= 1 or 2 <= 2)");

        Assert.assertEquals(new Boolean(false), result);
    }

    @Test
    public void andOrChain7Test() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 1 > 8 or 2 <= 1 and 1 >= 1 or 2 <= 2");

        Assert.assertEquals(new Boolean(true), result);
    }
}
