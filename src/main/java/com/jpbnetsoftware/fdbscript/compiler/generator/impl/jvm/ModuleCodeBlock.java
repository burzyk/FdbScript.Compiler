package com.jpbnetsoftware.fdbscript.compiler.generator.impl.jvm;

import com.jpbnetsoftware.fdbscript.compiler.generator.BlockType;
import com.jpbnetsoftware.fdbscript.compiler.generator.IModuleCodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import org.apache.bcel.Constants;
import org.apache.bcel.generic.*;

import java.util.List;

/**
 * Created by pawel on 05/04/15.
 */
public class ModuleCodeBlock implements IModuleCodeBlock {

    private BytecodeProvider provider;

    private String name;

    private List<ICodeBlock> definitions;

    private ICodeBlock expression;

    private byte[] compilationResult;

    public ModuleCodeBlock(BytecodeProvider provider, String name, List<ICodeBlock> definitions, ICodeBlock expression) {
        this.provider = provider;
        this.name = name;
        this.definitions = definitions;
        this.expression = expression;
    }

    @Override
    public void emit() {
        ClassGenerator classGenerator = ClassGenerator.beginClass(this.name);

        this.provider.setInstructionFactory(classGenerator.getInstructionFactory());
        this.provider.setInstructionList(classGenerator.getInstructionList());

        for (ICodeBlock d : this.definitions) {
            d.emit();
        }

        this.expression.emit();

        this.provider.getInstructionList().append(InstructionConstants.ARETURN);

        this.compilationResult = classGenerator.endClass();
    }

    @Override
    public BlockType getType() {
        return this.expression.getType();
    }

    @Override
    public byte[] getCompilationResult() {
        return this.compilationResult;
    }
}
