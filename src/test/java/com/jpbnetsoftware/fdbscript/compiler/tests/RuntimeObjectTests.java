package com.jpbnetsoftware.fdbscript.compiler.tests;

import com.jpbnetsoftware.fdbscript.compiler.tests.helpers.CompilerHelper;
import com.jpbnetsoftware.fdbscript.runtime.objects.RuntimeObject;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by pawel on 04/05/15.
 */
public class RuntimeObjectTests {

    @Test
    public void objectCreateSimpleTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "o = {ala: 2, ma: 4, kota: 8} " +
                "o");

        RuntimeObject o = (RuntimeObject) result;

        Assert.assertEquals(new Double(2), o.getValue("ala"));
        Assert.assertEquals(new Double(4), o.getValue("ma"));
        Assert.assertEquals(new Double(8), o.getValue("kota"));
    }

    @Test
    public void objectCompareSimpleTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "o1 = {ala: 2, ma: 4, kota: 8} " +
                "o2 = {ala: 2, ma: 4, kota: 8}" +
                "o1 == o2 ");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void objectCompareNotEqualTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "o1 = {ala: 2, ma: 4, kota: 8, ola: 8} " +
                "o2 = {ala: 2, ma: 4, kota: 8}" +
                "o1 == o2 ");

        Assert.assertEquals(new Boolean(false), result);
    }

    @Test
    public void objectCompareNotEqualNestedTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "o1 = {ala: 2, ma: 4, kota: 8, ola: { asa: true } } " +
                "o2 = {ala: 2, ma: 4, kota: 8, ola: { asa: false } }" +
                "o1 == o2 ");

        Assert.assertEquals(new Boolean(false), result);
    }

    @Test
    public void objectCompareEqualNestedTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "o1 = {ala: 2, ma: 4, kota: 8, ola: { asa: false } } " +
                "o2 = {ala: 2, ma: 4, kota: 8, ola: { asa: false } }" +
                "o1 == o2 ");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void objectMemberAccessSimpleTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "o1 = {ala: 2, ma: 4, kota: 8, ola: { asa: false } } " +
                "o2 = {ala: 2, ma: 4, kota: 8, ola: { asa: false } }" +
                "o1.ala == 2 ");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void objectMemberAccessCompareTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "o1 = {ala: 2, ma: 4, kota: 8, ola: { asa: false } } " +
                "o2 = {ala: 2, ma: 4, kota: 8, ola: { asa: false } }" +
                "o1.ala == o2.ala ");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void objectMemberAccessCompare2Test() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "o1 = {ala: 2, ma: 4, kota: 8, ola: { asa: false } } " +
                "o2 = {ala: 2, ma: 4, kota: 8, ola: { asa: false } }" +
                "o1.ala == o2.kota ");

        Assert.assertEquals(new Boolean(false), result);
    }

    @Test
    public void objectMemberAccessNestedTest() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "o1 = {ala: 2, ma: 4, kota: 8, ola: { asa: false } } " +
                "o2 = {ala: 2, ma: 4, kota: 8, ola: { asa: false } }" +
                "o1.ola.asa == o2.ola.asa ");

        Assert.assertEquals(new Boolean(true), result);
    }

    @Test
    public void objectMemberAccessNested2Test() throws Exception {
        Object result = CompilerHelper.compileAndInvoke("Test", "module Test " +
                "o1 = {ala: 2, ma: 4, kota: 8, ola: { asa: false } } " +
                "o2 = {ala: 2, ma: 4, kota: 8, ola: { asa: false } }" +
                "o1.ola == { asa: false }");

        Assert.assertEquals(new Boolean(true), result);
    }
}
