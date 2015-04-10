package com.jpbnetsoftware.fdbscript.compiler.generator.impl.jvm;

import com.jpbnetsoftware.fdbscript.compiler.generator.BlockType;
import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IDefinitionCodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.java.*;
import org.apache.bcel.generic.ALOAD;
import org.apache.bcel.generic.ASTORE;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionList;

import java.io.PrintStream;

/**
 * Created by pawel on 10/04/15.
 */
public class DefinitionCodeBlock implements IDefinitionCodeBlock {

    private BytecodeProvider provider;

    private int variableId;

    private String name;

    private ICodeBlock expression;

    public DefinitionCodeBlock(BytecodeProvider provider, int variableId, String name, ICodeBlock expression) {
        this.provider = provider;
        this.variableId = variableId;
        this.name = name;
        this.expression = expression;
    }

    public String getName() {
        return this.name;
    }

    public int getVariableId() {
        return this.variableId;
    }

    public ICodeBlock getExpression() {
        return this.expression;
    }

    @Override
    public void emit() {
        InstructionList il = this.provider.getInstructionList();

        this.expression.emit();

        il.append(new ASTORE(this.variableId));
    }

    @Override
    public BlockType getType() {
        return this.expression.getType();
    }
}
