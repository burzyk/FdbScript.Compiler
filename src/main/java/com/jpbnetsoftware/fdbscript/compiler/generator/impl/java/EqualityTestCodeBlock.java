package com.jpbnetsoftware.fdbscript.compiler.generator.impl.java;

import com.jpbnetsoftware.fdbscript.compiler.generator.BlockType;
import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;

import java.io.PrintStream;

/**
 * Created by pawel on 03/04/15.
 */
public class EqualityTestCodeBlock implements ICodeBlock {
    private ICodeBlock lhs;

    private boolean testEqual;

    private ICodeBlock rhs;

    private PrintStream out;

    public EqualityTestCodeBlock(ICodeBlock lhs, boolean testEqual, ICodeBlock rhs, PrintStream out) {
        this.lhs = lhs;
        this.testEqual = testEqual;
        this.rhs = rhs;
        this.out = out;
    }

    @Override
    public void emit() {

        this.out.print("(");

        this.lhs.emit();

        this.out.print(this.testEqual ? " == " : " != ");

        this.rhs.emit();

        this.out.print(")");
    }

    @Override
    public BlockType getType() {
        return BlockType.Boolean;
    }
}
