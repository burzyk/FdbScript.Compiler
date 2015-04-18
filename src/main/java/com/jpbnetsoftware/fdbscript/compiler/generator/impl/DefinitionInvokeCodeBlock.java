package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.IDefinitionCodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IEmitter;
import org.apache.bcel.Constants;
import org.apache.bcel.generic.ALOAD;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.Type;

/**
 * Created by pawel on 10/04/15.
 */
public class DefinitionInvokeCodeBlock extends JvmCodeBlock {

    private IDefinitionCodeBlock definition;

    public DefinitionInvokeCodeBlock(IDefinitionCodeBlock definition) {
        this.definition = definition;
    }

    @Override
    protected void emitInternal(IEmitter emitter, InstructionList il, InstructionFactory factory) {

        // loads the InvokeContext
        il.append(new ALOAD(1));

        // definition name
        il.append(factory.createConstant(this.definition.getName()));

        il.append(factory.createInvoke(
                "com.jpbnetsoftware.fdbscript.runtime.InvokeContext",
                "getValue",
                Type.OBJECT,
                new Type[]{Type.STRING},
                Constants.INVOKEVIRTUAL));
    }
}
