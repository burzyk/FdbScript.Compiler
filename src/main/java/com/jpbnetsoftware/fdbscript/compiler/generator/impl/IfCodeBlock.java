package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IEmitter;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.BytecodeProvider;
import org.apache.bcel.generic.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pawel on 10/04/15.
 */
public class IfCodeBlock extends JvmCodeBlock {

    private List<ICodeBlock> conditions;

    private ICodeBlock elseBlock;

    public IfCodeBlock(List<ICodeBlock> conditions, ICodeBlock elseBlock) {
        this.conditions = conditions;
        this.elseBlock = elseBlock;
    }

    @Override
    protected void emitInternal(IEmitter emitter, InstructionList il, InstructionFactory factory) {
        List<InstructionHandle> jumpToEndPlaceholders = new ArrayList<InstructionHandle>();

        for (ICodeBlock c : this.conditions) {
            c.emit(emitter);
            jumpToEndPlaceholders.add(((ConditionCodeBlock) c).getJumpToEndPlaceholder());
        }

        this.elseBlock.emit(emitter);
        InstructionHandle endInstruction = il.append(new NOP());

        for (InstructionHandle jumpToEndPlaceholder : jumpToEndPlaceholders) {
            il.insert(jumpToEndPlaceholder, new GOTO(endInstruction));
        }
    }
}
