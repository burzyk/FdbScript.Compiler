package com.jpbnetsoftware.fdbscript.compiler.generator.impl.jvm;

import com.jpbnetsoftware.fdbscript.compiler.generator.BlockType;
import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.jvm.helpers.BytecodeProvider;
import org.apache.bcel.Constants;
import org.apache.bcel.generic.*;

/**
 * Created by pawel on 05/04/15.
 */
public class EqualityTestCodeBlock implements ICodeBlock {

    private BytecodeProvider provider;

    private ICodeBlock lhs;

    private boolean testEqual;

    private ICodeBlock rhs;

    public EqualityTestCodeBlock(BytecodeProvider provider, ICodeBlock lhs, boolean testEqual, ICodeBlock rhs) {
        this.provider = provider;
        this.lhs = lhs;
        this.testEqual = testEqual;
        this.rhs = rhs;
    }

    @Override
    public void emit() {
        InstructionList il = this.provider.getInstructionList();
        InstructionFactory factory = this.provider.getInstructionFactory();

        this.lhs.emit();
        this.rhs.emit();

        String testMethod = this.testEqual ? "isEqual" : "isNotEqual";

        if (testMethod == null) {
            System.out.println("Unable to find the valid operation");
        }

        il.append(factory.createInvoke(
                "com.jpbnetsoftware.fdbscript.runtime.CompareRuntime",
                testMethod,
                Type.OBJECT,
                new Type[]{Type.OBJECT, Type.OBJECT},
                Constants.INVOKESTATIC));
    }

    @Override
    public BlockType getType() {
        return BlockType.Boolean;
    }
}
