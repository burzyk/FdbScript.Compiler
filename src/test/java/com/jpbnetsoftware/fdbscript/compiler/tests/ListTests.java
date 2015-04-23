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
        Assert.assertEquals(1.0, array[0]);
        Assert.assertEquals(2.0, array[1]);
        Assert.assertEquals(3.0, array[2]);
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
    public void indexDoubleNestedListTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test",
                "module Test " +
                        " z = [5, 6, 7]" +
                        " x = [1, z, 3]" +
                        " x[1][2]");

        Assert.assertEquals(new Double(7), result);
    }

    @Test
    public void rangeSingleTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test x = [1, 2, 3] x[:]");

        Assert.assertEquals(RuntimeList.class, result.getClass());
        Object[] array = ((RuntimeList) result).getList();

        Assert.assertEquals(3, array.length);
        Assert.assertEquals(1.0, array[0]);
        Assert.assertEquals(2.0, array[1]);
        Assert.assertEquals(3.0, array[2]);
    }

    @Test
    public void rangeDoubleTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test x = [1, 2, 3] x[:][1:]");

        Assert.assertEquals(RuntimeList.class, result.getClass());
        Object[] array = ((RuntimeList) result).getList();

        Assert.assertEquals(2, array.length);
        Assert.assertEquals(2.0, array[0]);
        Assert.assertEquals(3.0, array[1]);
    }

    @Test
    public void rangeBoundsTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test x = [1, 2, 3, 4, 5] x[1:3]");

        Assert.assertEquals(RuntimeList.class, result.getClass());
        Object[] array = ((RuntimeList) result).getList();

        Assert.assertEquals(2, array.length);
        Assert.assertEquals(2.0, array[0]);
        Assert.assertEquals(3.0, array[1]);
    }

    @Test
    public void listEqualDifferentLengthTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "x1 = [1, 2, 3, 4, 5] " +
                "x2 = [1, 2, 3, 4] " +
                "x1 == x2");

        Assert.assertEquals(new Boolean(false), result);
    }

    @Test
    public void listNotEqualDifferentLengthTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "x1 = [1, 2, 3, 4, 5] " +
                "x2 = [1, 2, 3, 4] " +
                "x1 != x2");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void listEqualWithDifferentObjectTypesTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "x1 = [1, 2, \"ala ma kota\", 4, 5] " +
                "x2 = [1, 2, \"ala ma kota\", 4, 5] " +
                "x1 == x2");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void listEqualNestedTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "x1 = [1, 2, [1, 2, 3], 4, 5] " +
                "x2 = [1, 2, [1, 2, 3], 4, 5] " +
                "x1 == x2");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void listNotEqualNested1Test() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "x1 = [1, 2, [1, 2, 3], 4, 5] " +
                "x2 = [1, 2, [1, 7, 3], 4, 5] " +
                "x1 == x2");

        Assert.assertEquals(new Boolean(false), result);
    }

    @Test
    public void listNotEqualNested2Test() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "x1 = [1, 2, [1, 2, 3], 4, 5] " +
                "x2 = [1, 2, [1, 7, 3], 4, 5] " +
                "x1 != x2");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void listAddElementFrontTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "x1 = 1 + [2, 3, 4] " +
                "x2 = [1, 2, 3, 4] " +
                "x1 == x2");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void listAddElementBackTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "x1 = [2, 3, 4] + 1 " +
                "x2 = [2, 3, 4, 1] " +
                "x1 == x2");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void listAddListFrontBackTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "x1 = [1, 2, 3] +  [4, 5, 6] " +
                "x2 = [1, 2, 3, 4, 5, 6] " +
                "x1 == x2");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void listAddListBackTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "x1 = [4, 5, 6] + [1, 2, 3] " +
                "x2 = [ 4, 5, 6, 1, 2, 3] " +
                "x1 == x2");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void listAddListVariablesTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "z = [1, 2, 3]" +
                "x1 = z + [4, 5, 6] + [1, 2, 3] + 8" +
                "x2 = [1, 2, 3, 4, 5, 6, 1, 2, 3, 8] " +
                "x1 == x2");

        Assert.assertEquals(new Boolean(true), result);
    }
}
