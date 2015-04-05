package com.jpbnetsoftware.fdbscriptcompiler.generator.impl.jvm;

import com.jpbnetsoftware.fdbscriptcompiler.generator.BlockType;
import com.jpbnetsoftware.fdbscriptcompiler.generator.ICodeBlock;

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
