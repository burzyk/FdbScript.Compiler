package com.jpbnetsoftware.fdbscriptcompiler.generator.impl.java;

import com.jpbnetsoftware.fdbscriptcompiler.generator.BlockType;
import com.jpbnetsoftware.fdbscriptcompiler.generator.BooleanOperation;
import com.jpbnetsoftware.fdbscriptcompiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscriptcompiler.generator.MathOperation;

import java.io.PrintStream;

/**
 * Created by pawel on 03/04/15.
 */
public class BooleanCodeBlock implements ICodeBlock {

    private ICodeBlock lhs;

    private BooleanOperation operation;

    private ICodeBlock rhs;

    private PrintStream out;

    public BooleanCodeBlock(ICodeBlock lhs, BooleanOperation operation, ICodeBlock rhs, PrintStream out) {
        this.lhs = lhs;
        this.operation = operation;
        this.rhs = rhs;
        this.out = out;
    }

    @Override
    public void emit() {

        this.out.print("(");

        this.lhs.emit();

        switch (operation) {
            case And:
                this.out.print(" && ");
                break;
            case Or:
                this.out.print(" || ");
                break;
        }

        this.rhs.emit();

        this.out.print(")");
    }

    @Override
    public BlockType getType() {
        return BlockType.Boolean;
    }
}
