package com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers;

import org.apache.bcel.Constants;
import org.apache.bcel.generic.InstructionConstants;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.Type;

/**
 * Created by pawel on 04/05/15.
 */
public class ObjectGenerator {

    public static void emitNewObject(String className, InstructionList il, InstructionFactory factory) {

        il.append(factory.createNew(className));
        il.append(InstructionConstants.DUP);
        il.append(factory.createInvoke(
                className,
                "<init>",
                Type.VOID,
                new Type[]{},
                Constants.INVOKESPECIAL));
    }
}
