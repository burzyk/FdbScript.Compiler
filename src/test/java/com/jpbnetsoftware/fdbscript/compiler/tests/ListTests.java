package com.jpbnetsoftware.fdbscript.compiler.tests;

import com.jpbnetsoftware.fdbscript.compiler.tests.helpers.CompilerHelper;
import com.jpbnetsoftware.fdbscript.runtime.RuntimeList;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by pawel on 22/04/15.
 */
public class ListTests {

    @Test
    public void initializerTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test x = [1, 2, 3] x");

        Assert.assertEquals(RuntimeList.class, result.getClass());
        Object[] array = ((RuntimeList) result).getList();

        Assert.assertEquals(3, array.length);
        Assert.assertEquals(1, array[0]);
        Assert.assertEquals(2, array[1]);
        Assert.assertEquals(3, array[2]);
    }

    @Test
    public void indexSingleTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test x = [1, 2, 3] x[1]");

        Assert.assertEquals(new Double(2), result);
    }

    @Test
    public void indexDoubleTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test x = [1, [5, 6, 7], 3] x[1][2]");

        Assert.assertEquals(new Double(7), result);
    }

    @Test
    public void rangeSingleTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test x = [1, 2, 3] x[:]");

        Assert.assertEquals(RuntimeList.class, result.getClass());
        Object[] array = ((RuntimeList) result).getList();

        Assert.assertEquals(3, array.length);
        Assert.assertEquals(1, array[0]);
        Assert.assertEquals(2, array[1]);
        Assert.assertEquals(3, array[2]);
    }

    @Test
    public void rangeDoubleTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test x = [1, 2, 3] x[:][1:]");

        Assert.assertEquals(RuntimeList.class, result.getClass());
        Object[] array = ((RuntimeList) result).getList();

        Assert.assertEquals(2, array.length);
        Assert.assertEquals(2, array[0]);
        Assert.assertEquals(3, array[1]);
    }

    @Test
    public void rangeBoundsTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test x = [1, 2, 3, 4, 5] x[1:3]");

        Assert.assertEquals(RuntimeList.class, result.getClass());
        Object[] array = ((RuntimeList) result).getList();

        Assert.assertEquals(2, array.length);
        Assert.assertEquals(2, array[0]);
        Assert.assertEquals(3, array[1]);
    }
}
