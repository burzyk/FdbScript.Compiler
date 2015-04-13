package com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers;

/**
 * Created by pawel on 10/04/15.
 */
public class JvmFunctionScope {

    private JvmFunctionScope parent;

    private BytecodeProvider provider;

    // Java uses stack to pass parameters to any method
    // first parameter is 'this', second parameter is always array of objects from IInvokable
    private int nextVariableId = 2;

    // this is index in the argument array
    private int nextArgumentId = 0;
    private ClassGenerator classGenerator;
    private String functionClassName;

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

    public void setClassGenerator(ClassGenerator classGenerator) {
        this.classGenerator = classGenerator;
    }

    public ClassGenerator getClassGenerator() {
        return classGenerator;
    }

    public void setFunctionClassName(String functionClassName) {
        this.functionClassName = functionClassName;
    }

    public String getFunctionClassName() {
        return functionClassName;
    }
}
