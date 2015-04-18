package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IDefinitionCodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IEmitter;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.BytecodeProvider;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionList;

import java.util.List;

/**
 * Created by pawel on 10/04/15.
 */
public class FunctionCodeBlock extends JvmCodeBlock {

    private String className;

    private List<IDefinitionCodeBlock> arguments;

    public FunctionCodeBlock(String className, List<IDefinitionCodeBlock> arguments) {
        this.className = className;
        this.arguments = arguments;
    }

    @Override
    protected void emitInternal(IEmitter emitter, InstructionList il, InstructionFactory factory) {
        il.append(factory.createNew(this.className));
    }
}
