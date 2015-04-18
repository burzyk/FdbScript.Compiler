package com.jpbnetsoftware.fdbscript.compiler.tests;

import com.jpbnetsoftware.fdbscript.compiler.tests.helpers.CompilerHelper;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by pawel on 18/04/15.
 */
public class IfTests {

    @Test
    public void if1Test() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test (1 == 1) -> 1 _ -> 2");

        Assert.assertEquals(new Double(1), result);
    }

    @Test
    public void if2Test() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test (1 != 1) -> 1 _ -> 2");

        Assert.assertEquals(new Double(2), result);
    }

    @Test
    public void if3Test() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test (1 != 1) -> 1 (1 == 1) -> 2 _ -> 3");

        Assert.assertEquals(new Double(2), result);
    }

    @Test
    public void if4Test() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test (3 < 1) -> 1 (2 < 1) -> 2 _ -> 3");

        Assert.assertEquals(new Double(3), result);
    }

    @Test
    public void if5Test() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test",
                "module Test " +
                        "(2 + 2 * 2 == 6 and 2 - 10 + 2 == -6) -> 1 " +
                        "_ -> 3");

        Assert.assertEquals(new Double(1), result);
    }

    @Test
    public void if6Test() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test",
                "module Test " +
                        "(2 + 2 * 2 == 8 and 2 - 10 + 2 == -6) -> 1 " +
                        "(2 + 2 * 2 == 6 and 2 - 10 + 2 == -6) -> 8 " +
                        "_ -> 3");

        Assert.assertEquals(new Double(8), result);
    }

    @Test
    public void if7Test() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test",
                "module Test " +
                        "(2 + 2 * 2 == 8 or 2 - 10 + 2 == -10) -> 1 " +
                        "(2 + 2 * 2 == 10 or 2 - 10 + 2 == -68) -> 8 " +
                        "_ -> 3");

        Assert.assertEquals(new Double(3), result);
    }
}
