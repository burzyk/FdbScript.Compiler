package com.jpbnetsoftware.fdbscriptcompiler.generator.impl.jvm;

import com.jpbnetsoftware.fdbscriptcompiler.generator.BlockType;
import com.jpbnetsoftware.fdbscriptcompiler.generator.CompareOperation;
import com.jpbnetsoftware.fdbscriptcompiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscriptcompiler.generator.MathOperation;
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

        il.append(InstructionConstants.DCMPL);
/*
        0: dload_1
        1: dload_3
        2: dcmpl
        3: iflt          10
        6: iconst_1
        7: goto          11
        10: iconst_0
        11: ireturn



             0: ldc2_w        #7                  // double 5.0d
       3: ldc2_w        #9                  // double 9.0d
       6: iflt          13
       9: dcmpl
      10: goto          15
      13: iconst_1
      14: iconst_0
      15: nop
      16: ireturn
*/

        InstructionHandle iconst_1 = il.append(InstructionConstants.ICONST_1);
        InstructionHandle iconst_0 = il.append(InstructionConstants.ICONST_0);
        InstructionHandle ifFalse = il.append(InstructionConstants.NOP);

        IfInstruction jmp =
                this.operation == CompareOperation.GreaterEqual ? new IFLT(iconst_0) :
                        this.operation == CompareOperation.GreaterThan ? new IFLE(iconst_0) :
                                this.operation == CompareOperation.LessEqual ? new IFGT(iconst_0) :
                                        this.operation == CompareOperation.LessThan ? new IFGE(iconst_0) :
                                                new IFLT(iconst_0);

        il.insert(iconst_1, jmp);
        il.insert(iconst_0, new GOTO(ifFalse));
    }

    @Override
    public BlockType getType() {
        return BlockType.Boolean;
    }
}
