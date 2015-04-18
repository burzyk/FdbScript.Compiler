package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.IEmitter;
import org.apache.bcel.generic.ALOAD;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionList;

/**
 * Created by pawel on 18/04/15.
 */
public class SelfDefinitionCodeBlock extends BaseDefinitionCodeBlock {

    public SelfDefinitionCodeBlock() {
        super("self");
    }

    @Override
    protected void emitInternal(IEmitter emitter, InstructionList il, InstructionFactory factory) {
        il.append(new ALOAD(0));
    }
}
