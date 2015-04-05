package com.jpbnetsoftware.fdbscriptcompiler.generator.impl.java;

import com.jpbnetsoftware.fdbscriptcompiler.generator.BlockType;
import com.jpbnetsoftware.fdbscriptcompiler.generator.ICodeBlock;

import java.io.PrintStream;

/**
 * Created by pawel on 03/04/15.
 */
public class NumberCodeBlock implements ICodeBlock {

    private double number;

    private PrintStream out;

    public NumberCodeBlock(double number, PrintStream out) {
        this.number = number;
        this.out = out;
    }

    @Override
    public void emit() {
        out.print(this.number);
    }

    @Override
    public BlockType getType() {
        return BlockType.Number;
    }
}
