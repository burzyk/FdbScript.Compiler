package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.BytecodeProvider;

/**
 * Created by pawel on 05/04/15.
 */
public class StringCodeBlock implements ICodeBlock {

    private BytecodeProvider provider;

    private String value;

    public StringCodeBlock(BytecodeProvider provider, String value) {
        this.provider = provider;
        this.value = value;
    }

    @Override
    public void emit() {
        this.provider.getInstructionList().append(
                this.provider.getInstructionFactory().createConstant(this.value));
    }
}