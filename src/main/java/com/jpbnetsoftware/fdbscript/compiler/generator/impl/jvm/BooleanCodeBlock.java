package com.jpbnetsoftware.fdbscript.compiler.generator.impl.jvm;

import com.jpbnetsoftware.fdbscript.compiler.generator.BlockType;
import com.jpbnetsoftware.fdbscript.compiler.generator.BooleanOperation;
import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.jvm.helpers.BytecodeProvider;
import org.apache.bcel.Constants;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.Type;

/**
 * Created by pawel on 07/04/15.
 */
public class BooleanCodeBlock implements ICodeBlock {

    private BytecodeProvider provider;

    private ICodeBlock lhs;

    private BooleanOperation operation;

    private ICodeBlock rhs;

    public BooleanCodeBlock(BytecodeProvider provider, ICodeBlock lhs, BooleanOperation operation, ICodeBlock rhs) {
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
                this.operation == BooleanOperation.And ? "and" :
                        this.operation == BooleanOperation.Or ? "or" : null;

        if (operationMethod == null) {
            System.out.println("Unable to find the valid operation");
        }

        il.append(factory.createInvoke(
                "com.jpbnetsoftware.fdbscript.runtime.BooleanRuntime",
                operationMethod,
                Type.OBJECT,
                new Type[]{Type.OBJECT, Type.OBJECT},
                Constants.INVOKESTATIC));
    }

    @Override
    public BlockType getType() {
        return BlockType.Boolean;
    }
}
