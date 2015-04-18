package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.IOutputManager;
import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IEmitter;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.BytecodeProvider;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.ClassGenerator;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionList;

import java.util.List;

/**
 * Created by pawel on 05/04/15.
 */
public class ModuleCodeBlock extends JvmCodeBlock {

    private IOutputManager outputManager;

    private String name;

    private List<ICodeBlock> definitions;

    private ICodeBlock expression;

    public ModuleCodeBlock(IOutputManager outputManager, String name, List<ICodeBlock> definitions, ICodeBlock expression) {
        this.outputManager = outputManager;
        this.name = name;
        this.definitions = definitions;
        this.expression = expression;
    }

    @Override
    protected void emitInternal(IEmitter emitter, InstructionList il, InstructionFactory factory) {
        ClassGenerator classGenerator = ClassGenerator.beginClass(this.name, new String[]{});

        BytecodeProvider provider = new BytecodeProvider(
                classGenerator.getInstructionList(),
                classGenerator.getInstructionFactory());

        for (ICodeBlock d : this.definitions) {
            d.emit(provider);
        }

        this.expression.emit(provider);

        try {
            this.outputManager.append(this.name, classGenerator.endClass());
        } catch (Exception e) {
            //TODO: error handling
            e.printStackTrace();
        }
    }
}
