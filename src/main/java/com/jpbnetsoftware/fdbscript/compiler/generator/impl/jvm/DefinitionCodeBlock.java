package com.jpbnetsoftware.fdbscript.compiler.generator.impl.jvm;

import com.jpbnetsoftware.fdbscript.compiler.generator.BlockType;
import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IDefinitionCodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.jvm.helpers.BytecodeProvider;
import org.apache.bcel.generic.ASTORE;
import org.apache.bcel.generic.InstructionList;

/**
 * Created by pawel on 10/04/15.
 */
public class DefinitionCodeBlock extends BaseDefinitionCodeBlock {

    private ICodeBlock expression;

    public DefinitionCodeBlock(BytecodeProvider provider, int variableId, String name, ICodeBlock expression) {
        super(provider, variableId, name);

        this.expression = expression;
    }

    @Override
    public void emit() {
        InstructionList il = this.provider.getInstructionList();

        this.expression.emit();

        il.append(new ASTORE(this.variableId));
    }

    @Override
    public BlockType getType() {
        return this.expression.getType();
    }
}
