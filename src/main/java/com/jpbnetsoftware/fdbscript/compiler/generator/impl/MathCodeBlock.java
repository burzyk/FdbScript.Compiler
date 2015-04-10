package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.MathOperation;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.BytecodeProvider;
import org.apache.bcel.Constants;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.Type;

/**
 * Created by pawel on 05/04/15.
 */
public class MathCodeBlock implements ICodeBlock {

    private BytecodeProvider provider;

    private ICodeBlock lhs;

    private MathOperation operation;

    private ICodeBlock rhs;

    public MathCodeBlock(BytecodeProvider provider, ICodeBlock lhs, MathOperation operation, ICodeBlock rhs) {
        this.provider = provider;
        this.lhs = lhs;
        this.operation = operation;
        this.rhs = rhs;
    }

    @Override
    public void emit() {
        InstructionList il = this.provider.getInstructionList();
        InstructionFactory factory = this.provider.getInstructionFactory();

        this.lhs.emit();
        this.rhs.emit();

        String operationMethod =
                this.operation == MathOperation.Plus ? "add" :
                        this.operation == MathOperation.Minus ? "sub" :
                                this.operation == MathOperation.Mul ? "mul" :
                                        this.operation == MathOperation.Div ? "div" : null;

        if (operationMethod == null) {
            System.out.println("Unable to find the valid operation");
        }

        il.append(factory.createInvoke(
                "com.jpbnetsoftware.fdbscript.runtime.MathRuntime",
                operationMethod,
                Type.OBJECT,
                new Type[]{Type.OBJECT, Type.OBJECT},
                Constants.INVOKESTATIC));
    }
}
