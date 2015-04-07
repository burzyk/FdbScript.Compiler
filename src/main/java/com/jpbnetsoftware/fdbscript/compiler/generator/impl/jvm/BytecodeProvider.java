package com.jpbnetsoftware.fdbscript.compiler.generator.impl.jvm;

import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionList;

/**
 * Created by pawel on 05/04/15.
 */
public class BytecodeProvider {

    private ConstantPoolGen constantPoolGen;

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

    public ConstantPoolGen getConstantPoolGen() {
        return constantPoolGen;
    }

    public void setConstantPoolGen(ConstantPoolGen constantPoolGen) {
        this.constantPoolGen = constantPoolGen;
    }
}
