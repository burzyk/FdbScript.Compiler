package com.jpbnetsoftware.fdbscript.compiler.generator.impl.jvm;

import com.jpbnetsoftware.fdbscript.compiler.generator.BlockType;
import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import org.apache.bcel.Constants;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.ObjectType;
import org.apache.bcel.generic.Type;

/**
 * Created by pawel on 05/04/15.
 */
public class NumberCodeBlock implements ICodeBlock {

    private BytecodeProvider provider;

    private double number;

    public NumberCodeBlock(BytecodeProvider provider, double number) {
        this.provider = provider;
        this.number = number;
    }

    @Override
    public void emit() {
        InstructionList il = this.provider.getInstructionList();
        InstructionFactory factory = this.provider.getInstructionFactory();

        il.append(factory.createConstant(this.number));
        il.append(factory.createInvoke(
                "java.lang.Double",
                "valueOf",
                new ObjectType("java.lang.Double"),
                new Type[]{Type.DOUBLE},
                Constants.INVOKESTATIC));
    }

    @Override
    public BlockType getType() {
        return BlockType.Number;
    }
}
