package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.IEmitter;
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

    private List<String> arguments;

    public FunctionCodeBlock(String className, List<String> arguments) {
        this.className = className;
        this.arguments = arguments;
    }

    @Override
    protected void emitInternal(IEmitter emitter, InstructionList il, InstructionFactory factory) {
        il.append(factory.createNew(this.className));
        il.append(InstructionConstants.DUP);
        il.append(factory.createInvoke(
                this.className,
                "<init>",
                Type.VOID,
                new Type[]{},
                Constants.INVOKESPECIAL));
    }
}
