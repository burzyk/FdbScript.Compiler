package com.jpbnetsoftware.fdbscript.compiler.generator.impl.java;

import com.jpbnetsoftware.fdbscript.compiler.generator.BlockType;
import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;

import java.io.PrintStream;

/**
 * Created by pawel on 04/04/15.
 */
public class ElseCodeBlock implements ICodeBlock {

    private ICodeBlock expression;

    private PrintStream out;

    public ElseCodeBlock(ICodeBlock expression, PrintStream out) {
        this.expression = expression;
        this.out = out;
    }

    @Override
    public void emit() {
        this.expression.emit();
    }

    @Override
    public BlockType getType() {
        return this.expression.getType();
    }
}
