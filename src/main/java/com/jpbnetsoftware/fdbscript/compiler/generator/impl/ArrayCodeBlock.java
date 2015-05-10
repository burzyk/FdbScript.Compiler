package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IEmitter;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.BytecodeProvider;
import org.apache.bcel.generic.*;

import java.util.List;

/**
 * Created by pawel on 10/05/15.
 */
public class ArrayCodeBlock extends JvmCodeBlock {

    private Type arrayType;

    private List<ICodeBlock> expressions;

    public ArrayCodeBlock(Type arrayType, List<ICodeBlock> expressions) {
        this.arrayType = arrayType;
        this.expressions = expressions;
    }

    @Override
    protected void emitInternal(IEmitter emitter, InstructionList il, InstructionFactory factory) {

        BytecodeProvider provider = (BytecodeProvider) emitter;
        int variableId = provider.getNextLocalVariableId();

        il.append(factory.createConstant(expressions.size()));
        il.append(factory.createNewArray(arrayType, (short) 1));
        il.append(new ASTORE(variableId));
        int i = 0;

        for (ICodeBlock c : expressions) {
            il.append(new ALOAD(variableId));
            il.append(factory.createConstant(i++));
            c.emit(emitter);
            il.append(new AASTORE());
        }

        il.append(new ALOAD(variableId));
    }
}
