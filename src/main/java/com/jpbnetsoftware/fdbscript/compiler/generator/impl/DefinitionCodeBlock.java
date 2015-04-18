package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IEmitter;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.BytecodeProvider;
import org.apache.bcel.generic.ASTORE;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionList;

/**
 * Created by pawel on 10/04/15.
 */
public class DefinitionCodeBlock extends BaseDefinitionCodeBlock {

    private ICodeBlock expression;

    public DefinitionCodeBlock(String name, ICodeBlock expression) {
        super(name);

        this.expression = expression;
    }

    @Override
    protected void emitInternal(IEmitter emitter, InstructionList il, InstructionFactory factory) {
        this.expression.emit(emitter);

        // TODO: implement
        //il.append(new ASTORE(this.variableId));
    }
}
