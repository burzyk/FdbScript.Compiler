package com.jpbnetsoftware.fdbscriptcompiler.generator.impl.jvm;

import com.jpbnetsoftware.fdbscriptcompiler.generator.BlockType;
import com.jpbnetsoftware.fdbscriptcompiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscriptcompiler.generator.IModuleCodeBlock;
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

    private ClassGen moduleClass;

    public ModuleCodeBlock(BytecodeProvider provider, String name, List<ICodeBlock> definitions, ICodeBlock expression) {
        this.provider = provider;
        this.name = name;
        this.definitions = definitions;
        this.expression = expression;
    }


    @Override
    public void emit() {
        Type returnType = BlockTypeTranslator.getJavaTypeName(this.getType());
        this.moduleClass = new ClassGen(
                this.name,
                "java.lang.Object",
                "<generated>",
                Constants.ACC_PUBLIC | Constants.ACC_SUPER,
                null);

        this.provider.setConstantPoolGen(this.moduleClass.getConstantPool());
        this.provider.setInstructionList(new InstructionList());

        MethodGen mg = new MethodGen(
                Constants.ACC_PUBLIC, // access flags
                returnType,               // return type
                new Type[]{},
                new String[]{}, // arg names
                "invoke",
                this.name,    // method, class
                this.provider.getInstructionList(),
                this.provider.getConstantPoolGen());

        this.provider.setInstructionFactory(new InstructionFactory(this.moduleClass));

        for (ICodeBlock d : this.definitions) {
            d.emit();
        }

        this.expression.emit();

        Instruction returnInstruction =
                returnType == Type.DOUBLE ? InstructionConstants.DRETURN :
                        returnType == Type.BOOLEAN ? InstructionConstants.IRETURN : InstructionConstants.ARETURN;

        this.provider.getInstructionList().append(returnInstruction);

        mg.setMaxStack();
        this.moduleClass.addMethod(mg.getMethod());
        this.provider.getInstructionList().dispose(); // Allow instruction handles to be reused
        this.moduleClass.addEmptyConstructor(Constants.ACC_PUBLIC);
    }

    @Override
    public BlockType getType() {
        return this.expression.getType();
    }

    @Override
    public byte[] getCompilationResult() {
        return this.moduleClass.getJavaClass().getBytes();
    }
}
