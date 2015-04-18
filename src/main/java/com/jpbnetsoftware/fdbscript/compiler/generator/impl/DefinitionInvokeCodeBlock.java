package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IDefinitionCodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IEmitter;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.BytecodeProvider;
import org.apache.bcel.generic.ALOAD;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionList;

/**
 * Created by pawel on 10/04/15.
 */
public class DefinitionInvokeCodeBlock extends JvmCodeBlock {

    private IDefinitionCodeBlock definition;

    public DefinitionInvokeCodeBlock(IDefinitionCodeBlock definition) {
        this.definition = definition;
    }

    @Override
    protected void emitInternal(IEmitter emitter, InstructionList il, InstructionFactory factory) {
        if(!(this.definition instanceof BaseDefinitionCodeBlock)) {
            // TODO : throw exception
        }

        // TODO: implement

        /*
        int variableId = ((BaseDefinitionCodeBlock)this.definition).getVariableId();

        il.append(new ALOAD(variableId));
        */
    }
}
