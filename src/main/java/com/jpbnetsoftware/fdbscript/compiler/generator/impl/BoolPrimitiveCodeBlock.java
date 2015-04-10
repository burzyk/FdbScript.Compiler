package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.BlockType;
import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.BytecodeProvider;
import org.apache.bcel.Constants;
import org.apache.bcel.generic.*;

/**
 * Created by pawel on 05/04/15.
 */
public class BoolPrimitiveCodeBlock implements ICodeBlock {

    private BytecodeProvider provider;

    private boolean value;

    public BoolPrimitiveCodeBlock(BytecodeProvider provider, boolean value) {
        this.provider = provider;
        this.value = value;
    }

    @Override
    public void emit() {
        InstructionList il = this.provider.getInstructionList();
        InstructionFactory factory = this.provider.getInstructionFactory();

        il.append(this.value ? InstructionConstants.ICONST_1 : InstructionConstants.ICONST_0);
        il.append(factory.createInvoke(
                "java.lang.Boolean",
                "valueOf",
                new ObjectType("java.lang.Boolean"),
                new Type[]{Type.BOOLEAN},
                Constants.INVOKESTATIC));
    }

    @Override
    public BlockType getType() {
        return BlockType.Boolean;
    }
}
