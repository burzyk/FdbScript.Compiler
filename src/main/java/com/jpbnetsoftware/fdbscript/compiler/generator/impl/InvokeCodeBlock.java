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

    private String functionName;

    private List<ICodeBlock> arguments;

    public InvokeCodeBlock(String functionName, List<ICodeBlock> arguments) {
        this.functionName = functionName;
        this.arguments = arguments;
    }

    @Override
    protected void emitInternal(IEmitter emitter, InstructionList il, InstructionFactory factory) {

        // loads the InvokeContext and gets the function
        il.append(new ALOAD(1));

        // load the function name
        il.append(factory.createConstant(this.functionName));

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
                        Type.STRING,
                        new ArrayType(Type.OBJECT, 1)},
                Constants.INVOKESTATIC));
    }
}
