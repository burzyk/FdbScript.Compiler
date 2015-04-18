package com.jpbnetsoftware.fdbscript.compiler.tests;

import com.jpbnetsoftware.fdbscript.compiler.tests.helpers.CompilerHelper;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by pawel on 18/04/15.
 */
public class FunctionTests {

    @Test
    public void functionNoParamsTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test",
                "module Test " +
                        "testFunction = f(): 2 + 2 * 2" +
                        " " +
                        "result = testFunction()" +
                        " " +
                        "(result == 6) -> true _ -> false");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void functionSimpleParamsTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test",
                "module Test " +
                        "add = f(x, y): x + y" +
                        " " +
                        "result = add(1, 1)" +
                        " " +
                        "(result == 2) -> true _ -> false");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void functionRecursionTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test",
                "module Test " +
                        "fac = f(n): (n == 0 or n == 1) -> 1 _ -> n * self(n - 1)" +
                        " " +
                        "result = fac(4)" +
                        " " +
                        "(result == 24) -> true _ -> false");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void functionRecursionAssignmentTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test",
                "module Test " +
                        "fac = f(n): this = self (n == 0 or n == 1) -> 1 _ -> n * this(n - 1)" +
                        " " +
                        "result = fac(4)" +
                        " " +
                        "(result == 24) -> true _ -> false");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void functionSimpleScopeTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test",
                "module Test " +
                        "x = 2 " +
                        "func = f(): x" +
                        " " +
                        "result = func()" +
                        " " +
                        "(result == 2) -> true _ -> false");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void functionDuplicateVariableTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test",
                "module Test " +
                        "x = 2 " +
                        "func = f(x): x" +
                        " " +
                        "result = func(3)" +
                        " " +
                        "(result == 3) -> true _ -> false");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void functionAsArgumentTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test",
                "module Test " +
                        "op = f(a, b): a + b " +
                        "" +
                        "func = f(y, a, b): y(a, b)" +
                        " " +
                        "result = func(op, 1, 6)" +
                        " " +
                        "(result == 7) -> true _ -> false");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void functionFibTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test",
                "module Test " +
                        "fibRec = f(n, p1, p2): (n <= 1) -> p2 _ -> self(n - 1, p2, p1 + p2) " +
                        "fib = f(n): fibRec(n, 0, 1) " +
                        " " +
                        "result = fib(6)" +
                        " " +
                        "(result == 8) -> true _ -> false");

        Assert.assertEquals(new Boolean(true), result);
    }

    /* waiting for closures
    @Test
    public void functionAsResultTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test",
                "module Test " +
                        "add = f(x): f(y): x + y " +
                        "add1 = add(1) " +
                        " " +
                        "result = add1(8)" +
                        " " +
                        "(result == 9) -> true _ -> false");

        Assert.assertEquals(new Boolean(true), result);
    }

    */
}
