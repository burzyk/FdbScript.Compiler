package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.BlockType;
import com.jpbnetsoftware.fdbscript.compiler.generator.CompareOperation;
import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.BytecodeProvider;
import org.apache.bcel.Constants;
import org.apache.bcel.generic.*;

/**
 * Created by pawel on 05/04/15.
 */
public class CompareCodeBlock implements ICodeBlock {

    private BytecodeProvider provider;

    private ICodeBlock lhs;

    private CompareOperation operation;

    private ICodeBlock rhs;

    public CompareCodeBlock(BytecodeProvider provider, ICodeBlock lhs, CompareOperation operation, ICodeBlock rhs) {
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

        String compareMethod =
                this.operation == CompareOperation.GreaterEqual ? "greaterEqual" :
                        this.operation == CompareOperation.GreaterThan ? "greaterThan" :
                                this.operation == CompareOperation.LessEqual ? "lessEqual" :
                                        this.operation == CompareOperation.LessThan ? "lessThan" :
                                                null;

        if (compareMethod == null) {
            System.out.println("Unable to find the valid operation");
        }

        il.append(factory.createInvoke(
                "com.jpbnetsoftware.fdbscript.runtime.CompareRuntime",
                compareMethod,
                Type.OBJECT,
                new Type[]{Type.OBJECT, Type.OBJECT},
                Constants.INVOKESTATIC));
    }

    @Override
    public BlockType getType() {
        return BlockType.Boolean;
    }
}
