package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IDefinitionCodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.BytecodeProvider;
import org.apache.bcel.generic.ALOAD;
import org.apache.bcel.generic.InstructionList;

/**
 * Created by pawel on 10/04/15.
 */
public class DefinitionInvokeCodeBlock implements ICodeBlock {

    private BytecodeProvider provider;

    private IDefinitionCodeBlock definition;

    public DefinitionInvokeCodeBlock(BytecodeProvider provider, IDefinitionCodeBlock definition) {
        this.provider = provider;
        this.definition = definition;
    }

    @Override
    public void emit() {
        InstructionList il = this.provider.getInstructionList();

        if(!(this.definition instanceof BaseDefinitionCodeBlock)) {
            // TODO : throw exception
        }

        int variableId = ((BaseDefinitionCodeBlock)this.definition).getVariableId();

        il.append(new ALOAD(variableId));
    }
}
