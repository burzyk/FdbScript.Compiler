package com.jpbnetsoftware.fdbscriptcompiler.generator.impl.jvm;

import com.jpbnetsoftware.fdbscriptcompiler.generator.BlockType;
import com.jpbnetsoftware.fdbscriptcompiler.generator.ICodeBlock;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionList;

/**
 * Created by pawel on 05/04/15.
 */
public class NumberCodeBlock implements ICodeBlock {

    private BytecodeProvider provider;

    private double number;

    public NumberCodeBlock(BytecodeProvider provider, double number) {
        this.provider = provider;
        this.number = number;
    }

    @Override
    public void emit() {
        InstructionList il = this.provider.getInstructionList();
        InstructionFactory factory = this.provider.getInstructionFactory();

        il.append(factory.createConstant(this.number));
    }

    @Override
    public BlockType getType() {
        return BlockType.Number;
    }
}