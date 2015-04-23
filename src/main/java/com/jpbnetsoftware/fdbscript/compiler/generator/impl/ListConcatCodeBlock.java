package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IEmitter;
import org.apache.bcel.Constants;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.Type;

/**
 * Created by pawel on 23/04/15.
 */
public class ListConcatCodeBlock extends JvmCodeBlock {

    private ICodeBlock lhs;

    private ICodeBlock rhs;

    public ListConcatCodeBlock(ICodeBlock lhs, ICodeBlock rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    protected void emitInternal(IEmitter emitter, InstructionList il, InstructionFactory factory) {

        this.lhs.emit(emitter);
        this.rhs.emit(emitter);

        il.append(factory.createInvoke(
                "com.jpbnetsoftware.fdbscript.runtime.RuntimeMethods",
                "listConcat",
                Type.OBJECT,
                new Type[]{Type.OBJECT, Type.OBJECT},
                Constants.INVOKESTATIC));
    }
}
