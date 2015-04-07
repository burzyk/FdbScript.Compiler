package com.jpbnetsoftware.fdbscriptcompiler.generator.impl.jvm;

import com.jpbnetsoftware.fdbscriptcompiler.generator.BlockType;
import com.jpbnetsoftware.fdbscriptcompiler.generator.ICodeBlock;
import org.apache.bcel.generic.InstructionConstants;

/**
 * Created by pawel on 05/04/15.
 */
public class BoolPrimitiveCodeBlock implements ICodeBlock {

    private BytecodeProvider provider;

    private boolean value;

    public BoolPrimitiveCodeBlock(BytecodeProvider provider, boolean value) {
        this.provider = provider;
        this.value = value;
    }

    @Override
    public void emit() {
        this.provider.getInstructionList().append(
                this.value ? InstructionConstants.ICONST_1 : InstructionConstants.ICONST_0);
    }

    @Override
    public BlockType getType() {
        return BlockType.Boolean;
    }
}
