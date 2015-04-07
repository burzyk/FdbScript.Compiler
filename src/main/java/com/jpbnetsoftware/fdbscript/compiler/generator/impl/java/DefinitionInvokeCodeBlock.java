package com.jpbnetsoftware.fdbscript.compiler.generator.impl.java;

import com.jpbnetsoftware.fdbscript.compiler.generator.IDefinitionCodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.BlockType;
import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;

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
