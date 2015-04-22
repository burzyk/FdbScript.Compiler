package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IEmitter;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.ArrayGenerator;
import org.apache.bcel.Constants;
import org.apache.bcel.generic.*;

import java.util.List;

/**
 * Created by pawel on 22/04/15.
 */
public class ListCodeBlock extends JvmCodeBlock {

    private List<ICodeBlock> initValues;

    public ListCodeBlock(List<ICodeBlock> initValues) {
        this.initValues = initValues;
    }

    @Override
    protected void emitInternal(IEmitter emitter, InstructionList il, InstructionFactory factory) {

        ArrayGenerator.emitArray(emitter, Type.OBJECT, this.initValues, 2);
        il.append(factory.createInvoke(
                "com.jpbnetsoftware.fdbscript.runtime.RuntimeList",
                "create",
                Type.OBJECT,
                new Type[]{new ArrayType(Type.OBJECT, 1)},
                Constants.INVOKESTATIC));
    }
}
