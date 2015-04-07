package com.jpbnetsoftware.fdbscript.compiler.generator.impl.java;

import com.jpbnetsoftware.fdbscript.compiler.generator.BlockType;
import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;

import java.io.PrintStream;

/**
 * Created by pawel on 03/04/15.
 */
public class BoolPrimitiveCodeBlock implements ICodeBlock {

    private boolean value;

    private PrintStream out;

    public BoolPrimitiveCodeBlock(boolean value, PrintStream out) {
        this.value = value;
        this.out = out;
    }

    @Override
    public void emit() {
        out.print(this.value);
    }

    @Override
    public BlockType getType() {
        return BlockType.Boolean;
    }
}
