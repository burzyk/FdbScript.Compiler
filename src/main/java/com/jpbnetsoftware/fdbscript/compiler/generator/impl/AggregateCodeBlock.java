package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IEmitter;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionList;

/**
 * Created by pawel on 05/05/15.
 */
public class AggregateCodeBlock extends JvmCodeBlock {

    private ICodeBlock[] codeBlocks;

    public AggregateCodeBlock(ICodeBlock... codeBlocks) {
        this.codeBlocks = codeBlocks;
    }

    @Override
    protected void emitInternal(IEmitter emitter, InstructionList il, InstructionFactory factory) {

        for (ICodeBlock c : this.codeBlocks) {
            c.emit(emitter);
        }
    }
}
