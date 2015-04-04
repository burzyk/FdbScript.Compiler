package com.jpbnetsoftware.fdbscriptcompiler.generator.impl.java;

import com.jpbnetsoftware.fdbscriptcompiler.generator.BlockType;
import com.jpbnetsoftware.fdbscriptcompiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscriptcompiler.generator.IDefinitionCodeBlock;

import java.io.PrintStream;

/**
 * Created by pawel on 04/04/15.
 */
public class DefinitionInvokeCodeBlock implements ICodeBlock {

    private IDefinitionCodeBlock definition;

    private PrintStream out;

    public DefinitionInvokeCodeBlock(IDefinitionCodeBlock definition, PrintStream out) {
        this.definition = definition;
        this.out = out;
    }

    @Override
    public void emit() {
        this.out.print(this.definition.getName());
    }

    @Override
    public BlockType getType() {
        return this.definition.getType();
    }
}
