package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IEmitter;
import org.apache.bcel.Constants;
import org.apache.bcel.generic.*;

/**
 * Created by pawel on 22/04/15.
 */
public class IndexCodeBlock extends JvmCodeBlock {

    private ICodeBlock first;

    private ICodeBlock second;

    private boolean separatorPresent;

    public IndexCodeBlock(ICodeBlock first, ICodeBlock second, boolean separatorPresent) {
        this.first = first;
        this.second = second;
        this.separatorPresent = separatorPresent;
    }

    @Override
    protected void emitInternal(IEmitter emitter, InstructionList il, InstructionFactory factory) {

        if (this.first != null) {
            this.first.emit(emitter);
        } else {
            il.append(InstructionConstants.ACONST_NULL);
        }

        if (this.second != null) {
            this.second.emit(emitter);
        } else {
            il.append(InstructionConstants.ACONST_NULL);
        }

        il.append(this.separatorPresent ? InstructionConstants.ICONST_1 : InstructionConstants.ICONST_0);

        il.append(factory.createInvoke(
                "com.jpbnetsoftware.fdbscript.runtime.RuntimeMethods",
                "index",
                Type.OBJECT,
                new Type[]{
                        Type.OBJECT,
                        Type.OBJECT,
                        Type.OBJECT,
                        Type.BOOLEAN},
                Constants.INVOKESTATIC));
    }
}
