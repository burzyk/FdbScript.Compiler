package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.BlockType;
import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IDefinitionCodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.BytecodeProvider;

import java.util.List;

/**
 * Created by pawel on 10/04/15.
 */
public class InvokeCodeBlock implements ICodeBlock {

    private BytecodeProvider provider;

    private IDefinitionCodeBlock definition;

    private List<ICodeBlock> arguments;

    public InvokeCodeBlock(BytecodeProvider provider, IDefinitionCodeBlock definition, List<ICodeBlock> arguments) {
        this.provider = provider;
        this.definition = definition;
        this.arguments = arguments;
    }

    @Override
    public void emit() {
        // TODO: emit invoke that accepts array as parameter
    }

    @Override
    public BlockType getType() {
        return BlockType.Any;
    }
}
