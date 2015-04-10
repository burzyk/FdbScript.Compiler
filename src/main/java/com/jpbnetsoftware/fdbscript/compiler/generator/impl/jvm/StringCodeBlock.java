package com.jpbnetsoftware.fdbscript.compiler.generator.impl.jvm;

import com.jpbnetsoftware.fdbscript.compiler.generator.BlockType;
import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.jvm.helpers.BytecodeProvider;

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

    @Override
    public BlockType getType() {
        return BlockType.String;
    }
}
