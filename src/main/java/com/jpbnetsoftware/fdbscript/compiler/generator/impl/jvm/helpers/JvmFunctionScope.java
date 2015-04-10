package com.jpbnetsoftware.fdbscript.compiler.generator.impl.jvm.helpers;

/**
 * Created by pawel on 10/04/15.
 */
public class JvmFunctionScope {

    private JvmFunctionScope parent;

    private BytecodeProvider provider;

    // Java uses stack to pass parameters to any method
    // first parameter is 'this', second parameter is always array of objects from IInvokable
    private int nextVariableId = 1;

    // this is index in the argument array
    private int nextArgumentId = -1;

    public JvmFunctionScope(JvmFunctionScope parent) {
        this.parent = parent;
        this.provider = new BytecodeProvider();

    }

    public BytecodeProvider getProvider() {
        return provider;
    }

    public int getNextVariableId() {
        return nextVariableId++;
    }

    public int getNextArgumentId() {
        return nextArgumentId++;
    }

    public JvmFunctionScope getParent() {
        return parent;
    }
}
