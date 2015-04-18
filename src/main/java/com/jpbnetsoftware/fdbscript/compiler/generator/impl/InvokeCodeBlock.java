package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IDefinitionCodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IEmitter;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.BytecodeProvider;
import org.apache.bcel.Constants;
import org.apache.bcel.generic.*;

import java.util.List;

/**
 * Created by pawel on 10/04/15.
 */
public class InvokeCodeBlock extends JvmCodeBlock {

    private IDefinitionCodeBlock definition;

    private List<ICodeBlock> arguments;

    public InvokeCodeBlock(IDefinitionCodeBlock definition, List<ICodeBlock> arguments) {
        this.definition = definition;
        this.arguments = arguments;
    }

    @Override
    protected void emitInternal(IEmitter emitter, InstructionList il, InstructionFactory factory) {

        // loads the InvokeContext and gets the function
        il.append(new ALOAD(1));
        il.append(InstructionConstants.DUP);
        il.append(factory.createConstant(this.definition.getName()));
        il.append(factory.createInvoke(
                "com.jpbnetsoftware.fdbscript.runtime.InvokeContext",
                "getValue",
                Type.OBJECT,
                new Type[]{Type.STRING},
                Constants.INVOKEVIRTUAL));

        // creates an array of arguments
        il.append(factory.createConstant(this.arguments.size()));
        il.append(factory.createNewArray(Type.OBJECT, (short) 1));
        il.append(new ASTORE(2));
        int i = 0;

        for (ICodeBlock c : arguments) {
            il.append(new ALOAD(2));
            il.append(factory.createConstant(i++));
            c.emit(emitter);
            il.append(new AASTORE());
        }

        // call 'invoke' from runtime
        il.append(new ALOAD(2));
        il.append(factory.createInvoke(
                "com.jpbnetsoftware.fdbscript.runtime.RuntimeMethods",
                "invoke",
                Type.OBJECT,
                new Type[]{
                        new ObjectType("com.jpbnetsoftware.fdbscript.runtime.InvokeContext"),
                        new ObjectType("com.jpbnetsoftware.fdbscript.runtime.IInvokable"),
                        new ArrayType(Type.OBJECT, 1)},
                Constants.INVOKESTATIC));
    }
}
