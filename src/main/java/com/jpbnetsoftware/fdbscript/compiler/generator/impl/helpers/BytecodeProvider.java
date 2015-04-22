package com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers;

import com.jpbnetsoftware.fdbscript.compiler.generator.IEmitter;
import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionList;

/**
 * Created by pawel on 05/04/15.
 */
public class BytecodeProvider implements IEmitter {

    private InstructionList instructionList;

    private InstructionFactory instructionFactory;

    // first one is occupied by 'this', second one by 'InvokeContext'
    private int currentLocalVariableId = 2;

    public BytecodeProvider(InstructionList instructionList, InstructionFactory instructionFactory, boolean isForInvokable) {
        this.instructionList = instructionList;
        this.instructionFactory = instructionFactory;

        if (!isForInvokable) {
            this.currentLocalVariableId = 1;
        }
    }

    public BytecodeProvider(InstructionList instructionList, InstructionFactory instructionFactory) {
        this.instructionList = instructionList;
        this.instructionFactory = instructionFactory;
    }

    public InstructionFactory getInstructionFactory() {
        return instructionFactory;
    }

    public InstructionList getInstructionList() {
        return instructionList;
    }

    public int getNextLocalVariableId() {
        return this.currentLocalVariableId++;
    }
}
