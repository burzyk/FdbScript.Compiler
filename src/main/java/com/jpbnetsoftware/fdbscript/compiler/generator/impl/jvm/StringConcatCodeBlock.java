package com.jpbnetsoftware.fdbscript.compiler.generator.impl.jvm;

import com.jpbnetsoftware.fdbscript.compiler.generator.BlockType;
import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
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

        il.append(factory.createNew(new ObjectType("java.lang.StringBuilder")));
        il.append(InstructionConstants.DUP);
        il.append(factory.createInvoke(
                "java.lang.StringBuilder",
                "<init>",
                Type.VOID,
                new Type[]{},
                Constants.INVOKESPECIAL));

        this.lhs.emit();
        il.append(factory.createInvoke(
                "java.lang.StringBuilder",
                "append",
                new ObjectType("java.lang.StringBuilder"),
                new Type[]{BlockTypeTranslator.getJavaTypeName(this.lhs.getType())},
                Constants.INVOKEVIRTUAL));

        this.rhs.emit();
        il.append(factory.createInvoke(
                "java.lang.StringBuilder",
                "append",
                new ObjectType("java.lang.StringBuilder"),
                new Type[]{BlockTypeTranslator.getJavaTypeName(this.rhs.getType())},
                Constants.INVOKEVIRTUAL));

        il.append(factory.createInvoke(
                "java.lang.StringBuilder",
                "toString",
                Type.STRING,
                new Type[]{},
                Constants.INVOKEVIRTUAL));
    }

    @Override
    public BlockType getType() {
        return BlockType.String;
    }
}
