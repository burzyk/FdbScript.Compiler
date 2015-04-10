package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.BlockType;
import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.BytecodeProvider;
import org.apache.bcel.Constants;
import org.apache.bcel.generic.*;

/**
 * Created by pawel on 05/04/15.
 */
public class StringConcatCodeBlock implements ICodeBlock {

    private BytecodeProvider provider;

    private ICodeBlock lhs;

    private ICodeBlock rhs;

    public StringConcatCodeBlock(BytecodeProvider provider, ICodeBlock lhs, ICodeBlock rhs) {
        this.provider = provider;
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public void emit() {
        InstructionList il = this.provider.getInstructionList();
        InstructionFactory factory = this.provider.getInstructionFactory();

        this.lhs.emit();
        this.rhs.emit();

        il.append(factory.createInvoke(
                "com.jpbnetsoftware.fdbscript.runtime.StringRuntime",
                "concat",
                Type.OBJECT,
                new Type[]{Type.OBJECT, Type.OBJECT},
                Constants.INVOKESTATIC));
    }

    @Override
    public BlockType getType() {
        return BlockType.String;
    }
}
