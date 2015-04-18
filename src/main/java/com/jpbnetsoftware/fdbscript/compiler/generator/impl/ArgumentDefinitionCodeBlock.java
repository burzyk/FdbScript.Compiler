package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IEmitter;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.BytecodeProvider;
import org.apache.bcel.generic.*;

/**
 * Created by pawel on 10/04/15.
 */
public class ArgumentDefinitionCodeBlock extends BaseDefinitionCodeBlock {

    public ArgumentDefinitionCodeBlock(String name) {
        super(name);
    }

    @Override
    protected void emitInternal(IEmitter emitter, InstructionList il, InstructionFactory factory) {
    }
}
