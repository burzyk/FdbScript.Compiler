package com.jpbnetsoftware.fdbscript.compiler.generator.impl.java;

import com.jpbnetsoftware.fdbscript.compiler.generator.BlockType;
import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;

import java.io.PrintStream;

/**
 * Created by pawel on 03/04/15.
 */
public class StringCodeBock implements ICodeBlock {

    private String text;

    private PrintStream out;

    public StringCodeBock(String text, PrintStream out) {
        this.text = text;
        this.out = out;
    }

    @Override
    public void emit() {
        out.print(this.text);
    }

    @Override
    public BlockType getType() {
        return BlockType.String;
    }
}
