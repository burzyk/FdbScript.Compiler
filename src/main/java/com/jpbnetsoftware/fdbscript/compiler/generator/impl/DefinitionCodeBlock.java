package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IEmitter;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.BytecodeProvider;
import org.apache.bcel.Constants;
import org.apache.bcel.generic.*;

/**
 * Created by pawel on 10/04/15.
 */
public class DefinitionCodeBlock extends JvmCodeBlock {

    private ICodeBlock expression;

    private String name;

    public DefinitionCodeBlock(String name, ICodeBlock expression) {
        this.name = name;
        this.expression = expression;
    }

    @Override
    protected void emitInternal(IEmitter emitter, InstructionList il, InstructionFactory factory) {

        // loads the InvokeContext
        il.append(new ALOAD(1));

        // definition name
        il.append(factory.createConstant(this.name));

        // definition value
        this.expression.emit(emitter);

        il.append(factory.createInvoke(
                "com.jpbnetsoftware.fdbscript.runtime.InvokeContext",
                "defineValue",
                Type.VOID,
                new Type[]{Type.STRING, Type.OBJECT},
                Constants.INVOKEVIRTUAL));
    }
}
