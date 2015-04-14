package com.jpbnetsoftware.fdbscript.compiler.tests;

import com.jpbnetsoftware.fdbscript.compiler.tests.helpers.CompilerHelper;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by pawel on 14/04/15.
 */
public class StringTests {

    @Test
    public void constStringTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test \"ala\"");

        Assert.assertEquals("ala", result);
    }

    @Test
    public void concatStringTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test \"ala\" + \" ma kota\"");

        Assert.assertEquals("ala ma kota", result);
    }

    @Test
    public void concatMultipleStringTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test \"ala\" + \" ma kota\" + \", ola ma asa\"");

        Assert.assertEquals("ala ma kota, ola ma asa", result);
    }

    @Test
    public void concatMathTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test  4 + \"ala\" + 3");

        Assert.assertEquals("4.0ala3.0", result);
    }
}
