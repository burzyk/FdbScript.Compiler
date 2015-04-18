package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IEmitter;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.BytecodeProvider;
import org.apache.bcel.Constants;
import org.apache.bcel.generic.*;

/**
 * Created by pawel on 10/04/15.
 */
public class ConditionCodeBlock extends JvmCodeBlock {

    private ICodeBlock condition;

    private ICodeBlock expression;

    private InstructionHandle jumpToEndPlaceholder;

    public ConditionCodeBlock(ICodeBlock condition, ICodeBlock expression) {
        this.condition = condition;
        this.expression = expression;
    }

    public InstructionHandle getJumpToEndPlaceholder() {
        return jumpToEndPlaceholder;
    }

    @Override
    protected void emitInternal(IEmitter emitter, InstructionList il, InstructionFactory factory) {
        this.condition.emit(emitter);
        il.append(factory.createCheckCast(new ObjectType("java.lang.Boolean")));
        il.append(factory.createInvoke("java.lang.Boolean",
                "booleanValue",
                Type.BOOLEAN,
                new Type[]{},
                Constants.INVOKEVIRTUAL));

        InstructionHandle comparePlaceholder = il.append(new NOP());
        this.expression.emit(emitter);
        this.jumpToEndPlaceholder = il.append(new NOP());
        InstructionHandle endPlaceholder = il.append(new NOP());

        il.insert(comparePlaceholder, new IFEQ(endPlaceholder));
    }
}
