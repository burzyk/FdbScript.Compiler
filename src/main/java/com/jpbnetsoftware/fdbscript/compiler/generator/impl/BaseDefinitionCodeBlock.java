package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.IDefinitionCodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.BytecodeProvider;

/**
 * Created by pawel on 10/04/15.
 */
public abstract class BaseDefinitionCodeBlock extends JvmCodeBlock implements IDefinitionCodeBlock {

    protected String name;

    public BaseDefinitionCodeBlock(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
