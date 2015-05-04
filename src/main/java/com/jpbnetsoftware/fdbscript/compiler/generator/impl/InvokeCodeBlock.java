package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IEmitter;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.ArrayGenerator;
import org.apache.bcel.Constants;
import org.apache.bcel.generic.*;

import java.util.List;

/**
 * Created by pawel on 10/04/15.
 */
public class InvokeCodeBlock extends JvmCodeBlock {

    private ICodeBlock definitionInvoke;

    private List<ICodeBlock> arguments;

    public InvokeCodeBlock(ICodeBlock definitionInvoke, List<ICodeBlock> arguments) {
        this.definitionInvoke = definitionInvoke;
        this.arguments = arguments;
    }

    @Override
    protected void emitInternal(IEmitter emitter, InstructionList il, InstructionFactory factory) {

        // loads the InvokeContext
        il.append(new ALOAD(1));

        // get the definition onto the stack
        this.definitionInvoke.emit(emitter);

        // create arguments array
        ArrayGenerator.emitArray(emitter, Type.OBJECT, this.arguments);

        il.append(factory.createInvoke(
                "com.jpbnetsoftware.fdbscript.runtime.RuntimeMethods",
                "invoke",
                Type.OBJECT,
                new Type[]{
                        new ObjectType("com.jpbnetsoftware.fdbscript.runtime.InvokeContext"),
                        Type.OBJECT,
                        new ArrayType(Type.OBJECT, 1)},
                Constants.INVOKESTATIC));
    }
}
