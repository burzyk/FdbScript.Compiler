package com.jpbnetsoftware.fdbscriptcompiler.operations;

import org.apache.bcel.generic.InstructionConstants;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionList;

/**
 * Created by pawel on 30/03/15.
 */
public class MinusOperation extends BaseOperation {

    @Override
    public void execute(InstructionList il, InstructionFactory factory) {
        il.append(InstructionConstants.ISUB);
    }
}
