package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.CompareOperation;
import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IEmitter;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.BytecodeProvider;
import org.apache.bcel.Constants;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.Type;

/**
 * Created by pawel on 05/04/15.
 */
public class CompareCodeBlock extends JvmCodeBlock {

    private ICodeBlock lhs;

    private CompareOperation operation;

    private ICodeBlock rhs;

    public CompareCodeBlock(ICodeBlock lhs, CompareOperation operation, ICodeBlock rhs) {
        this.lhs = lhs;
        this.operation = operation;
        this.rhs = rhs;
    }

    @Override
    protected void emitInternal(IEmitter emitter, InstructionList il, InstructionFactory factory) {
        this.lhs.emit(emitter);
        this.rhs.emit(emitter);

        String compareMethod =
                this.operation == CompareOperation.GreaterEqual ? "greaterEqual" :
                        this.operation == CompareOperation.GreaterThan ? "greaterThan" :
                                this.operation == CompareOperation.LessEqual ? "lessEqual" :
                                        this.operation == CompareOperation.LessThan ? "lessThan" :
                                                this.operation == CompareOperation.Equal ? "isEqual" :
                                                        this.operation == CompareOperation.NotEqual ? "isNotEqual" : null;

        if (compareMethod == null) {
            System.out.println("Unable to find the valid operation");
        }

        il.append(factory.createInvoke(
                "com.jpbnetsoftware.fdbscript.runtime.RuntimeMethods",
                compareMethod,
                Type.OBJECT,
                new Type[]{Type.OBJECT, Type.OBJECT},
                Constants.INVOKESTATIC));
    }
}
