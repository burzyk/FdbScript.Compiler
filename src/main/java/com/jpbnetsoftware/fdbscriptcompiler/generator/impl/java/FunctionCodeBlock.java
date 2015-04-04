package com.jpbnetsoftware.fdbscriptcompiler.generator.impl.java;

import com.jpbnetsoftware.fdbscriptcompiler.generator.BlockType;
import com.jpbnetsoftware.fdbscriptcompiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscriptcompiler.generator.IFunctionCodeBlock;

import java.io.PrintStream;

/**
 * Created by pawel on 04/04/15.
 */
public class FunctionCodeBlock implements IFunctionCodeBlock {

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

    @Override
    public BlockType getFunctionType() {
        return this.type;
    }
}
