package com.jpbnetsoftware.fdbscript.compiler.generator.impl.jvm;

import com.jpbnetsoftware.fdbscript.compiler.generator.IDefinitionCodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.jvm.helpers.BytecodeProvider;

/**
 * Created by pawel on 10/04/15.
 */
public abstract class BaseDefinitionCodeBlock implements IDefinitionCodeBlock {

    protected BytecodeProvider provider;

    protected int variableId;

    protected String name;

    public BaseDefinitionCodeBlock(BytecodeProvider provider, int variableId, String name) {
        this.provider = provider;
        this.variableId = variableId;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getVariableId() {
        return this.variableId;
    }
}
