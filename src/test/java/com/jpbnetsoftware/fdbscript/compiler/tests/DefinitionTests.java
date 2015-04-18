package com.jpbnetsoftware.fdbscript.compiler.tests;

import com.jpbnetsoftware.fdbscript.compiler.tests.helpers.CompilerHelper;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by pawel on 18/04/15.
 */
public class DefinitionTests {

    @Test
    public void definitionSimpleTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test",
                "module Test " +
                        "one = 1" +
                        "one");

        Assert.assertEquals(new Double(1), result);
    }

    @Test
    public void definition1Test() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test",
                "module Test " +
                        "one = 1" +
                        "two = 2" +
                        "(one == one) -> one _ -> two");

        Assert.assertEquals(new Double(1), result);
    }

    @Test
    public void definition2Test() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test",
                "module Test " +
                        "one = 1" +
                        "two = 2" +
                        "three = one + two" +
                        "" +
                        "(one != one) -> two _ -> three");

        Assert.assertEquals(new Double(3), result);
    }

    @Test
    public void definition3Test() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "one = 1" +
                "oneString = one + \"ala ma kota\"" +
                "result = \"1.0ala ma kota\"" +
                "" +
                "(result == oneString) -> true _ -> false");

        Assert.assertEquals(new Boolean(true), result);
    }
}
