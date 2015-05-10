package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IEmitter;
import org.apache.bcel.Constants;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.Type;

import java.util.Map;

/**
 * Created by pawel on 04/05/15.
 */
public class ObjectCodeBlock extends JvmCodeBlock {

    private Map<String, ICodeBlock> members;

    public ObjectCodeBlock(Map<String, ICodeBlock> members) {
        this.members = members;
    }

    @Override
    protected void emitInternal(IEmitter emitter, InstructionList il, InstructionFactory factory) {

        il.append(factory.createInvoke(
                "com.jpbnetsoftware.fdbscript.runtime.RuntimeMethods",
                "createObject",
                Type.OBJECT,
                new Type[]{},
                Constants.INVOKESTATIC));

        for (String key : this.members.keySet()) {
            ICodeBlock value = this.members.get(key);

            il.append(factory.createConstant(key));
            value.emit(emitter);

            il.append(factory.createInvoke(
                    "com.jpbnetsoftware.fdbscript.runtime.RuntimeMethods",
                    "extendObject",
                    Type.OBJECT,
                    new Type[]{Type.OBJECT, Type.STRING, Type.OBJECT},
                    Constants.INVOKESTATIC));

        }
    }
}
