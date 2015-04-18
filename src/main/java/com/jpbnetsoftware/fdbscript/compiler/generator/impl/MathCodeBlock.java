package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IEmitter;
import com.jpbnetsoftware.fdbscript.compiler.generator.MathOperation;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.BytecodeProvider;
import org.apache.bcel.Constants;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.Type;

/**
 * Created by pawel on 05/04/15.
 */
public class MathCodeBlock extends JvmCodeBlock {

    private ICodeBlock lhs;

    private MathOperation operation;

    private ICodeBlock rhs;

    public MathCodeBlock(ICodeBlock lhs, MathOperation operation, ICodeBlock rhs) {
        this.lhs = lhs;
        this.operation = operation;
        this.rhs = rhs;
    }

    @Override
    protected void emitInternal(IEmitter emitter, InstructionList il, InstructionFactory factory) {
        this.lhs.emit(emitter);
        this.rhs.emit(emitter);

        String operationMethod =
                this.operation == MathOperation.Plus ? "add" :
                        this.operation == MathOperation.Minus ? "sub" :
                                this.operation == MathOperation.Mul ? "mul" :
                                        this.operation == MathOperation.Div ? "div" : null;

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
