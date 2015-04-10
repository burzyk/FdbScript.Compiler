package com.jpbnetsoftware.fdbscript.compiler.generator.impl.jvm;

import com.jpbnetsoftware.fdbscript.compiler.generator.BlockType;
import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;

/**
 * Created by pawel on 10/04/15.
 */
public class ElseCodeBlock implements ICodeBlock {

    private ICodeBlock expression;

    public ElseCodeBlock(ICodeBlock expression) {
        this.expression = expression;
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
