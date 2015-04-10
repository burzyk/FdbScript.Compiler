package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.BytecodeProvider;

/**
 * Created by pawel on 10/04/15.
 */
public class ArgumentDefinitionCodeBlock extends BaseDefinitionCodeBlock {

    public ArgumentDefinitionCodeBlock(BytecodeProvider provider, int argumentId, String name) {
        super(provider, argumentId, name);
    }

    @Override
    public void emit() {
        // TODO: emit bytecode definition which load the argumentId element
        // of the input array into a local variable
    }
}
