package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.IEmitter;
import org.apache.bcel.generic.ALOAD;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionList;

/**
 * Created by pawel on 10/05/15.
 */
public class GetContextCodeBlock extends JvmCodeBlock {
    @Override
    protected void emitInternal(IEmitter emitter, InstructionList il, InstructionFactory factory) {
        il.append(new ALOAD(1));
    }
}
