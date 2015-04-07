package com.jpbnetsoftware.fdbscript.compiler.generator.impl.java;

import com.jpbnetsoftware.fdbscript.compiler.generator.BlockType;
import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;

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
        return this.elseBlock.getType();
    }
}
