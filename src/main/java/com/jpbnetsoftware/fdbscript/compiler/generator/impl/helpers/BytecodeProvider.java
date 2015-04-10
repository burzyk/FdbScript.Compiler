package com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers;

import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionList;

/**
 * Created by pawel on 05/04/15.
 */
public class BytecodeProvider {

    private InstructionList instructionList;

    private InstructionFactory instructionFactory;

    public InstructionFactory getInstructionFactory() {
        return instructionFactory;
    }

    public void setInstructionFactory(InstructionFactory instructionFactory) {
        this.instructionFactory = instructionFactory;
    }

    public InstructionList getInstructionList() {
        return instructionList;
    }

    public void setInstructionList(InstructionList instructionList) {
        this.instructionList = instructionList;
    }
}
