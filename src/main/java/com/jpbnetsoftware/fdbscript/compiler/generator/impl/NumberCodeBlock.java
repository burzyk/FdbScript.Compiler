package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IEmitter;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.BytecodeProvider;
import org.apache.bcel.Constants;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.ObjectType;
import org.apache.bcel.generic.Type;

/**
 * Created by pawel on 05/04/15.
 */
public class NumberCodeBlock extends JvmCodeBlock {

    private double number;

    public NumberCodeBlock(double number) {
        this.number = number;
    }

    @Override
    protected void emitInternal(IEmitter emitter, InstructionList il, InstructionFactory factory) {
        il.append(factory.createConstant(this.number));

        il.append(factory.createInvoke(
                "com.jpbnetsoftware.fdbscript.runtime.RuntimeMethods",
                "createNumber",
                Type.OBJECT,
                new Type[]{Type.DOUBLE},
                Constants.INVOKESTATIC));
    }
}
