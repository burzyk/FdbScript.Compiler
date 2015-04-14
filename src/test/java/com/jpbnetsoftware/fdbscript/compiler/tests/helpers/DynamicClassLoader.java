package com.jpbnetsoftware.fdbscript.compiler.tests.helpers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by pawel on 14/04/15.
 */
public class DynamicClassLoader extends ClassLoader {

    private Map<String, byte[]> generatedClasses = new HashMap<String, byte[]>();

    public void addClass(String name, byte[] bytecode) {
        this.generatedClasses.put(name, bytecode);
    }

    public Set<String> getAvailableClasses() {
        return this.generatedClasses.keySet();
    }

    @Override
    protected Class<?> findClass(final String name) throws ClassNotFoundException {
        byte[] classBytecode = this.generatedClasses.get(name);
        return defineClass(name, classBytecode, 0, classBytecode.length);
    }
}
