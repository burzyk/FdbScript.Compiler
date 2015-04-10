package com.jpbnetsoftware.fdbscript.compiler.generator.impl.jvm;

import com.jpbnetsoftware.fdbscript.compiler.generator.BlockType;
import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.jvm.helpers.BytecodeProvider;
import org.apache.bcel.Constants;
import org.apache.bcel.generic.*;

/**
 * Created by pawel on 10/04/15.
 */
public class ConditionCodeBlock implements ICodeBlock {

    private BytecodeProvider provider;

    private ICodeBlock condition;

    private ICodeBlock expression;

    private InstructionHandle jumpToEndPlaceholder;

    public ConditionCodeBlock(BytecodeProvider provider, ICodeBlock condition, ICodeBlock expression) {
        this.provider = provider;
        this.condition = condition;
        this.expression = expression;
    }

    @Override
    public void emit() {
        InstructionList il = this.provider.getInstructionList();
        InstructionFactory factory = this.provider.getInstructionFactory();

        this.condition.emit();
        il.append(factory.createCheckCast(new ObjectType("java.lang.Boolean")));
        il.append(factory.createInvoke("java.lang.Boolean",
                "booleanValue",
                Type.BOOLEAN,
                new Type[]{},
                Constants.INVOKEVIRTUAL));

        InstructionHandle comparePlaceholder = il.append(new NOP());
        this.expression.emit();
        this.jumpToEndPlaceholder = il.append(new NOP());
        InstructionHandle endPlaceholder = il.append(new NOP());

        il.insert(comparePlaceholder, new IFEQ(endPlaceholder));
    }

    @Override
    public BlockType getType() {
        return this.expression.getType();
    }

    public InstructionHandle getJumpToEndPlaceholder() {
        return jumpToEndPlaceholder;
    }
}
