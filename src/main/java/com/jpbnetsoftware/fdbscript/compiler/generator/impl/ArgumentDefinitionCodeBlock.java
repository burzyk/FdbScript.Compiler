package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.BytecodeProvider;
import org.apache.bcel.generic.*;

/**
 * Created by pawel on 10/04/15.
 */
public class ArgumentDefinitionCodeBlock extends BaseDefinitionCodeBlock {

    private int argumentId;

    private int arrayVariableId;

    public ArgumentDefinitionCodeBlock(BytecodeProvider provider, int arrayVariableId, int argumentId, int variableId, String name) {
        super(provider, variableId, name);

        this.arrayVariableId = arrayVariableId;
        this.argumentId = argumentId;
    }

    @Override
    public void emit() {
        InstructionList il = this.provider.getInstructionList();
        InstructionFactory factory = this.provider.getInstructionFactory();

        il.append(new ALOAD(this.arrayVariableId));
        il.append(factory.createConstant(this.argumentId));
        il.append(new AALOAD());
        il.append(new ASTORE(this.variableId));
    }
}
