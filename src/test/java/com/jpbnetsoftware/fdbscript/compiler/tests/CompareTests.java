package com.jpbnetsoftware.fdbscript.compiler.tests;

import com.jpbnetsoftware.fdbscript.compiler.tests.helpers.CompilerHelper;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by pawel on 14/04/15.
 */
public class CompareTests {

    @Test
    public void simpleNumberTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 3 > 4");

        Assert.assertEquals(new Boolean(false), result);
    }
}
