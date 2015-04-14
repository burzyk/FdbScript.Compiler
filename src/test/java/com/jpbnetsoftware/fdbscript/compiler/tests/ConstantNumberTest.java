package com.jpbnetsoftware.fdbscript.compiler.tests;

import com.jpbnetsoftware.fdbscript.compiler.tests.helpers.CompilerHelper;
import com.jpbnetsoftware.fdbscript.runtime.IInvokable;
import com.jpbnetsoftware.fdbscript.runtime.InvokeContext;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by pawel on 05/04/15.
 */
public class ConstantNumberTest {

    @Test
    public void simpleNumber() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test 10");

        Assert.assertEquals(result, new Double(10));
        Assert.assertNotEquals(result, new Double(100));
    }
}
