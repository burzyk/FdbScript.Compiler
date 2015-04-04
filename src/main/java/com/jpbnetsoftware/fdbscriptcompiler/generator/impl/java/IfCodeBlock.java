package com.jpbnetsoftware.fdbscriptcompiler.generator.impl.java;

import com.jpbnetsoftware.fdbscriptcompiler.generator.BlockType;
import com.jpbnetsoftware.fdbscriptcompiler.generator.ICodeBlock;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by pawel on 04/04/15.
 */
public class IfCodeBlock implements ICodeBlock {

    private List<ICodeBlock> conditions;

    private ICodeBlock elseBlock;

    private PrintStream out;

    public IfCodeBlock(List<ICodeBlock> conditions, ICodeBlock elseBlock, PrintStream out) {
        this.conditions = conditions;
        this.elseBlock = elseBlock;
        this.out = out;
    }

    @Override
    public void emit() {
        for (ICodeBlock c : this.conditions) {
            c.emit();
        }

        this.elseBlock.emit();
    }

    @Override
    public BlockType getType() {
        BlockType t = this.conditions.get(0).getType();

        for (ICodeBlock c : this.conditions) {
            if (c.getType() != t) {
                this.out.println("Invalid type");
            }
        }

        if (this.elseBlock.getType() != t) {
            this.out.println("Invalid type");
        }

        return t;
    }
}
