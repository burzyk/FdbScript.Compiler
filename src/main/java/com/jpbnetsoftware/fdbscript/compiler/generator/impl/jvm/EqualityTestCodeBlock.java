package com.jpbnetsoftware.fdbscriptcompiler.generator.impl.jvm;

import com.jpbnetsoftware.fdbscriptcompiler.generator.BlockType;
import com.jpbnetsoftware.fdbscriptcompiler.generator.CompareOperation;
import com.jpbnetsoftware.fdbscriptcompiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscriptcompiler.generator.MathOperation;
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

        if (this.lhs.getType() == BlockType.Boolean) {
            il.append(InstructionConstants.ISUB);
        } else if (this.lhs.getType() == BlockType.Number) {
            il.append(InstructionConstants.DCMPL);
        } else if (this.lhs.getType() == BlockType.String) {
            il.append(factory.createInvoke("java.lang.String",
                    "compareTo",
                    Type.INT,
                    new Type[]{Type.STRING},
                    Constants.INVOKEVIRTUAL));
        } else {
            // TODO: throw error
        }

        InstructionHandle iconst_1 = il.append(InstructionConstants.ICONST_1);
        InstructionHandle iconst_0 = il.append(InstructionConstants.ICONST_0);
        InstructionHandle ifFalse = il.append(InstructionConstants.NOP);

        il.insert(iconst_1, this.testEqual ? new IFNE(iconst_0) : new IFEQ(iconst_0));
        il.insert(iconst_0, new GOTO(ifFalse));
    }

    @Override
    public BlockType getType() {
        return BlockType.Boolean;
    }
}
