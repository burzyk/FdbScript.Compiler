package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.BooleanOperation;
import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IEmitter;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.BytecodeProvider;
import org.apache.bcel.Constants;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.Type;

/**
 * Created by pawel on 07/04/15.
 */
public class BooleanCodeBlock extends JvmCodeBlock {

    private ICodeBlock lhs;

    private BooleanOperation operation;

    private ICodeBlock rhs;

    public BooleanCodeBlock(ICodeBlock lhs, BooleanOperation operation, ICodeBlock rhs) {
        this.lhs = lhs;
        this.operation = operation;
        this.rhs = rhs;
    }

    @Override
    protected void emitInternal(IEmitter emitter, InstructionList il, InstructionFactory factory) {
        this.lhs.emit(emitter);
        this.rhs.emit(emitter);

        String operationMethod =
                this.operation == BooleanOperation.And ? "and" :
                        this.operation == BooleanOperation.Or ? "or" : null;

        if (operationMethod == null) {
            System.out.println("Unable to find the valid operation");
        }

        il.append(factory.createInvoke(
                "com.jpbnetsoftware.fdbscript.runtime.RuntimeMethods",
                operationMethod,
                Type.OBJECT,
                new Type[]{Type.OBJECT, Type.OBJECT},
                Constants.INVOKESTATIC));
    }
}
