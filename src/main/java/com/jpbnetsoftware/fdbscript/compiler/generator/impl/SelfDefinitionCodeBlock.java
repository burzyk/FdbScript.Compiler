package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.BlockType;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.BytecodeProvider;

/**
 * Created by pawel on 10/04/15.
 */
public class SelfDefinitionCodeBlock extends BaseDefinitionCodeBlock {

    public SelfDefinitionCodeBlock(BytecodeProvider provider, int variableId, String name) {
        super(provider, variableId, name);
    }

    @Override
    public void emit() {
        // TODO: throw on invoke
        // empty
    }

    @Override
    public BlockType getType() {
        return BlockType.Any;
    }
}
