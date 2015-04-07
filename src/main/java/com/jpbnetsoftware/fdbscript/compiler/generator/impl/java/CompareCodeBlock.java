package com.jpbnetsoftware.fdbscriptcompiler.generator.impl.java;

import com.jpbnetsoftware.fdbscriptcompiler.generator.BlockType;
import com.jpbnetsoftware.fdbscriptcompiler.generator.CompareOperation;
import com.jpbnetsoftware.fdbscriptcompiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscriptcompiler.generator.MathOperation;

import java.io.PrintStream;

/**
 * Created by pawel on 03/04/15.
 */
public class CompareCodeBlock implements ICodeBlock {
    private ICodeBlock lhs;

    private CompareOperation operation;

    private ICodeBlock rhs;

    private PrintStream out;

    public CompareCodeBlock(ICodeBlock lhs, CompareOperation operation, ICodeBlock rhs, PrintStream out) {
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
            case GreaterEqual:
                this.out.print(" >= ");
                break;
            case GreaterThan:
                this.out.print(" > ");
                break;
            case LessEqual:
                this.out.print(" <= ");
                break;
            case LessThan:
                this.out.print(" < ");
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
