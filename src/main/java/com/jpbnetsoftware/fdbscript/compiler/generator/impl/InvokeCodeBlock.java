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
        int i = 0;



        // TODO: reimplement with IInvokable

        /*
        if (!(definition instanceof BaseDefinitionCodeBlock)) {
            // TODO: runtime error
        }

        BaseDefinitionCodeBlock definitionCodeBlock = (BaseDefinitionCodeBlock) definition;

        il.append(new ALOAD((definitionCodeBlock).getVariableId()));
        il.append(factory.createConstant(arguments.size()));
        il.append(factory.createNewArray(Type.OBJECT, (short) 1));
        il.append(InstructionConstants.DUP);
        il.append(new ASTORE(this.argumentsArrayVariableId));

        for (ICodeBlock c : arguments) {
            il.append(new ALOAD(this.argumentsArrayVariableId));
            il.append(factory.createConstant(i));
            c.emit(emitter);

            il.append(new AASTORE());
            i++;
        }

        il.append(factory.createInvoke(
                "com.jpbnetsoftware.fdbscript.runtime.IInvokable",
                "invoke",
                Type.OBJECT,
                new Type[]{new ArrayType(Type.OBJECT, 1)},
                Constants.INVOKEINTERFACE));

        */
    }
}
