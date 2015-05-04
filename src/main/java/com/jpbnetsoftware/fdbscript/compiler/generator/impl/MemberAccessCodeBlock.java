package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IEmitter;
import org.apache.bcel.Constants;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.Type;

import java.util.List;

/**
 * Created by pawel on 04/05/15.
 */
public class MemberAccessCodeBlock extends JvmCodeBlock {

    private ICodeBlock valueSource;

    private List<String> ids;

    public MemberAccessCodeBlock(ICodeBlock valueSource, List<String> ids) {
        this.valueSource = valueSource;
        this.ids = ids;
    }

    @Override
    protected void emitInternal(IEmitter emitter, InstructionList il, InstructionFactory factory) {

        this.valueSource.emit(emitter);

        for (String id : this.ids) {

            il.append(factory.createConstant(id));
            il.append(factory.createInvoke(
                    "com.jpbnetsoftware.fdbscript.runtime.RuntimeMethods",
                    "accessMember",
                    Type.OBJECT,
                    new Type[]{Type.OBJECT, Type.STRING},
                    Constants.INVOKESTATIC));
        }
    }
}
