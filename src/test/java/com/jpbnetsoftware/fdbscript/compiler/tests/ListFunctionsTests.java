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

    @Test
    public void rangeReverseSimpleTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "x1 = range(2, 6) " +
                "x2 = reverse(x1)" +
                "x2 == [5, 4, 3, 2]");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void rangeReverseMaterializedTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "x1 = [4, 5, 9]" +
                "x2 = reverse(x1)" +
                "x2 == [9, 5, 4]");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void rangeFilterReverseMapChainTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "x1 = reverse(map(filter(range(10, 20), f(e, i): e > 15), f(e, i): e + 10))" +
                "x1 == [29, 28, 27, 26]");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void reduceSimpleTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "x1 = reduce(range(10, 15), 0, f(acc, e): acc + e)" +
                "x1 == 60");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void reduceSimpleWithInjectedDefinitionsTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "x1 = reduce(range(10, 15), 0, f(): $acc + $e)" +
                "x1 == 60");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void lengthRangeTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "x1 = length(range(10, 20))" +
                "x1 == 10");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void lengthMaterializedTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "x1 = length([4, 7, 10, 10])" +
                "x1 == 4");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void allSimpleTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "x1 = all([4, 7, 10, 10], f(e, i): e < 20)" +
                "x1");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void allSimpleFalseTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "x1 = all([4, 7, 20, 10], f(e, i): e < 20)" +
                "x1");

        Assert.assertEquals(new Boolean(false), result);
    }
}
