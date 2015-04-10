package com.jpbnetsoftware.fdbscript.compiler.generator.impl.jvm;

import com.jpbnetsoftware.fdbscript.compiler.generator.BlockType;
import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IDefinitionCodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.jvm.helpers.BytecodeProvider;
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

        if(!(this.definition instanceof DefinitionCodeBlock)) {
            // TODO : throw exception
        }

        int variableId = ((DefinitionCodeBlock)this.definition).getVariableId();

        il.append(new ALOAD(variableId));
    }

    @Override
    public BlockType getType() {
        return this.definition.getType();
    }
}
