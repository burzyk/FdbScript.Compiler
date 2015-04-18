package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IEmitter;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.BytecodeProvider;
import org.apache.bcel.Constants;
import org.apache.bcel.generic.*;

/**
 * Created by pawel on 05/04/15.
 */
public class BoolPrimitiveCodeBlock extends JvmCodeBlock {

    private boolean value;

    public BoolPrimitiveCodeBlock(boolean value) {
        this.value = value;
    }

    @Override
    protected void emitInternal(IEmitter emitter, InstructionList il, InstructionFactory factory) {
        il.append(this.value ? InstructionConstants.ICONST_1 : InstructionConstants.ICONST_0);
        il.append(factory.createInvoke(
                "java.lang.Boolean",
                "valueOf",
                new ObjectType("java.lang.Boolean"),
                new Type[]{Type.BOOLEAN},
                Constants.INVOKESTATIC));
    }
}
