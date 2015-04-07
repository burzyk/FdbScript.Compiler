package com.jpbnetsoftware.fdbscript.compiler.generator.impl.jvm;

import com.jpbnetsoftware.fdbscript.compiler.generator.BlockType;
import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.MathOperation;
import org.apache.bcel.generic.InstructionConstants;
import org.apache.bcel.generic.InstructionList;

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

        this.lhs.emit();
        this.rhs.emit();

        switch (this.operation){
            case Plus:
                il.append(InstructionConstants.DADD);
                break;
            case Minus:
                il.append(InstructionConstants.DSUB);
                break;
            case Mul:
                il.append(InstructionConstants.DMUL);
                break;
            case Div:
                il.append(InstructionConstants.DDIV);
                break;
        }
    }

    @Override
    public BlockType getType() {
        return BlockType.Number;
    }
}
