package com.jpbnetsoftware.fdbscript.compiler.generator.impl.java;

import com.jpbnetsoftware.fdbscript.compiler.generator.BlockType;
import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;

import java.io.PrintStream;

/**
 * Created by pawel on 04/04/15.
 */
public class FunctionCodeBlock implements ICodeBlock {

    private String name;

    private PrintStream out;

    private BlockType type;

    public FunctionCodeBlock(String name, BlockType type, PrintStream out) {
        this.name = name;
        this.type = type;
        this.out = out;
    }

    @Override
    public void emit() {
        this.out.print(" new " + this.name + "()");
    }

    @Override
    public BlockType getType() {
        return BlockType.Function;
    }

    public BlockType getFunctionType() {
        return this.type;
    }
}
