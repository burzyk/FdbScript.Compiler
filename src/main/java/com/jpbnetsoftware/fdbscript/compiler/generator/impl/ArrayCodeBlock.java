package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IEmitter;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.ArrayGenerator;
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
        ArrayGenerator.emitArray(emitter, this.arrayType, this.expressions);
    }
}
