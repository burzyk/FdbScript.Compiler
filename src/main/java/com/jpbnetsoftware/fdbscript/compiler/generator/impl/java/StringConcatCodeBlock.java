package com.jpbnetsoftware.fdbscript.compiler.generator.impl.java;

import com.jpbnetsoftware.fdbscript.compiler.generator.BlockType;
import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;

import java.io.PrintStream;

/**
 * Created by pawel on 03/04/15.
 */
public class StringConcatCodeBlock implements ICodeBlock {

    private ICodeBlock lhs;

    private ICodeBlock rhs;

    private PrintStream out;

    public StringConcatCodeBlock(ICodeBlock lhs, ICodeBlock rhs, PrintStream out) {
        this.lhs = lhs;
        this.rhs = rhs;
        this.out = out;
    }

    @Override
    public void emit() {

        this.lhs.emit();
        this.out.print(" + ");
        this.rhs.emit();
    }

    @Override
    public BlockType getType() {
        return BlockType.String;
    }
}
