package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.BytecodeProvider;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionList;

/**
 * Created by pawel on 10/04/15.
 */
public class FunctionCodeBlock implements ICodeBlock {

    private BytecodeProvider provider;

    private String className;

    public FunctionCodeBlock(BytecodeProvider provider, String className) {
        this.provider = provider;
        this.className = className;
    }

    @Override
    public void emit() {
        InstructionList il = this.provider.getInstructionList();
        InstructionFactory factory = this.provider.getInstructionFactory();

        il.append(factory.createNew(this.className));
    }

    public String getClassName() {
        return this.className;
    }
}
