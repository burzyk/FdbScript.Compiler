package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.IEmitter;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.ObjectGenerator;
import org.apache.bcel.Constants;
import org.apache.bcel.generic.InstructionConstants;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.Type;

import java.util.List;

/**
 * Created by pawel on 10/04/15.
 */
public class FunctionCodeBlock extends JvmCodeBlock {

    private String className;

    public FunctionCodeBlock(String className) {
        this.className = className;
    }

    @Override
    protected void emitInternal(IEmitter emitter, InstructionList il, InstructionFactory factory) {

        ObjectGenerator.emitNewObject(this.className, il, factory);
    }
}
