package com.jpbnetsoftware.fdbscript.compiler.generator.impl.java;

import com.jpbnetsoftware.fdbscript.compiler.generator.BlockType;
import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;

import java.io.PrintStream;

/**
 * Created by pawel on 04/04/15.
 */
public class ConditionCodeBlock implements ICodeBlock {

    private ICodeBlock condition;

    private ICodeBlock expression;

    private PrintStream out;

    public ConditionCodeBlock(ICodeBlock condition, ICodeBlock expression, PrintStream out) {
        this.condition = condition;
        this.expression = expression;
        this.out = out;
    }

    @Override
    public void emit() {
        this.condition.emit();
        this.out.print(" ? ");
        this.expression.emit();
        this.out.print(" : ");
    }

    @Override
    public BlockType getType() {
        return this.expression.getType();
    }
}
