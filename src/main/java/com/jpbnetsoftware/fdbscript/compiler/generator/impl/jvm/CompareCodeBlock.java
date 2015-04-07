package com.jpbnetsoftware.fdbscript.compiler.generator.impl.jvm;

import com.jpbnetsoftware.fdbscript.compiler.generator.BlockType;
import com.jpbnetsoftware.fdbscript.compiler.generator.CompareOperation;
import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
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

        this.lhs.emit();
        this.rhs.emit();

        il.append(InstructionConstants.DCMPL);

        InstructionHandle iconst_1 = il.append(InstructionConstants.ICONST_1);
        InstructionHandle iconst_0 = il.append(InstructionConstants.ICONST_0);
        InstructionHandle ifFalse = il.append(InstructionConstants.NOP);

        IfInstruction jmp =
                this.operation == CompareOperation.GreaterEqual ? new IFLT(iconst_0) :
                        this.operation == CompareOperation.GreaterThan ? new IFLE(iconst_0) :
                                this.operation == CompareOperation.LessEqual ? new IFGT(iconst_0) :
                                        this.operation == CompareOperation.LessThan ? new IFGE(iconst_0) :
                                                null;
        // TODO: if jmp null then error

        il.insert(iconst_1, jmp);
        il.insert(iconst_0, new GOTO(ifFalse));
    }

    @Override
    public BlockType getType() {
        return BlockType.Boolean;
    }
}
