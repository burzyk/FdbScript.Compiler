package com.jpbnetsoftware.fdbscript.compiler.generator.impl.jvm;

import com.jpbnetsoftware.fdbscript.compiler.generator.BlockType;
import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.jvm.helpers.BytecodeProvider;
import org.apache.bcel.generic.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pawel on 10/04/15.
 */
public class IfCodeBlock implements ICodeBlock {

    private BytecodeProvider provider;

    private List<ICodeBlock> conditions;

    private ICodeBlock elseBlock;

    public IfCodeBlock(BytecodeProvider provider, List<ICodeBlock> conditions, ICodeBlock elseBlock) {
        this.provider = provider;
        this.conditions = conditions;
        this.elseBlock = elseBlock;
    }

    @Override
    public void emit() {
        InstructionList il = this.provider.getInstructionList();
        List<InstructionHandle> jumpToEndPlaceholders = new ArrayList<InstructionHandle>();

        for (ICodeBlock c : this.conditions) {
            c.emit();
            jumpToEndPlaceholders.add(((ConditionCodeBlock) c).getJumpToEndPlaceholder());
        }

        this.elseBlock.emit();
        InstructionHandle endInstruction = il.append(new NOP());

        for (InstructionHandle jumpToEndPlaceholder : jumpToEndPlaceholders) {
            il.insert(jumpToEndPlaceholder, new GOTO(endInstruction));
        }
    }

    @Override
    public BlockType getType() {
        return this.elseBlock.getType();
    }
}
