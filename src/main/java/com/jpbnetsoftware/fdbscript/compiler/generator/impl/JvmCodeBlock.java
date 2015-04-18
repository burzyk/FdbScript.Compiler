package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IEmitter;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.BytecodeProvider;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionList;

/**
 * Created by pawel on 18/04/15.
 */
public abstract class JvmCodeBlock implements ICodeBlock {

    @Override
    public void emit(IEmitter emitter) {

        if (emitter != null) {
            BytecodeProvider provider = (BytecodeProvider) emitter;
            this.emitInternal(provider, provider.getInstructionList(), provider.getInstructionFactory());
        } else {
            this.emitInternal(null, null, null);
        }
    }

    protected abstract void emitInternal(IEmitter emitter, InstructionList il, InstructionFactory factory);
}
