package com.jpbnetsoftware.fdbscriptcompiler.generator.impl.java;

import com.jpbnetsoftware.fdbscriptcompiler.generator.BlockType;
import com.jpbnetsoftware.fdbscriptcompiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscriptcompiler.generator.MathOperation;

import java.io.PrintStream;

/**
 * Created by pawel on 03/04/15.
 */
public class MathCodeBlock implements ICodeBlock {

    private ICodeBlock lhs;

    private MathOperation operation;

    private ICodeBlock rhs;

    private PrintStream out;

    public MathCodeBlock(ICodeBlock lhs, MathOperation operation, ICodeBlock rhs, PrintStream out) {
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
            case Plus:
                this.out.print(" + ");
                break;
            case Minus:
                this.out.print(" - ");
                break;
            case Mul:
                this.out.print(" * ");
                break;
            case Div:
                this.out.print(" / ");
                break;
        }

        this.rhs.emit();

        this.out.print(")");
    }

    @Override
    public BlockType getType() {
        return BlockType.Number;
    }
}
