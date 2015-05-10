package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.IEmitter;
import org.apache.bcel.Constants;
import org.apache.bcel.generic.InstructionConstants;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.Type;

/**
 * Created by pawel on 10/05/15.
 */
public class NewObjectCodeBlock extends JvmCodeBlock {

    private String className;

    public NewObjectCodeBlock(String className) {
        this.className = className;
    }

    @Override
    protected void emitInternal(IEmitter emitter, InstructionList il, InstructionFactory factory) {

        il.append(factory.createNew(className));
        il.append(InstructionConstants.DUP);
        il.append(factory.createInvoke(
                className,
                "<init>",
                Type.VOID,
                new Type[]{},
                Constants.INVOKESPECIAL));
    }
}
