package com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers;

import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IEmitter;
import org.apache.bcel.generic.*;

import java.util.List;

/**
 * Created by pawel on 22/04/15.
 */
public class ArrayGenerator {

    public static void emitArray(IEmitter emitter, Type arrayType, List<ICodeBlock> expressions) {

        BytecodeProvider provider = (BytecodeProvider) emitter;
        InstructionList il = provider.getInstructionList();
        InstructionFactory factory = provider.getInstructionFactory();
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
