package com.jpbnetsoftware.fdbscriptcompiler.generator.impl.jvm;

import com.jpbnetsoftware.fdbscriptcompiler.generator.BlockType;
import com.jpbnetsoftware.fdbscriptcompiler.generator.ICodeBlock;
import com.sun.org.apache.bcel.internal.Constants;
import org.apache.bcel.generic.*;

import java.util.List;

/**
 * Created by pawel on 05/04/15.
 */
public class ModuleCodeBlock implements ICodeBlock {

    private BytecodeProvider provider;

    private String name;

    private List<ICodeBlock> definitions;

    private ICodeBlock expression;

    public ModuleCodeBlock(BytecodeProvider provider, String name, List<ICodeBlock> definitions, ICodeBlock expression) {
        this.provider = provider;
        this.name = name;
        this.definitions = definitions;
        this.expression = expression;
    }


    @Override
    public void emit() {
        Type returnType = BlockTypeTranslator.getJavaTypeName(this.getType());
        ClassGen cg = new ClassGen(
                this.name,
                "java.lang.Object",
                "<generated>",
                Constants.ACC_PUBLIC | Constants.ACC_SUPER,
                null);

        this.provider.setConstantPoolGen(cg.getConstantPool());
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

        this.provider.setInstructionFactory(new InstructionFactory(cg));

        for (ICodeBlock d : this.definitions) {
            d.emit();
        }

        this.expression.emit();

        Instruction returnInstruction =
                returnType == Type.DOUBLE ? InstructionConstants.DRETURN :
                        returnType == Type.BOOLEAN ? InstructionConstants.IRETURN : InstructionConstants.ARETURN;
        
        this.provider.getInstructionList().append(returnInstruction);

        mg.setMaxStack();
        cg.addMethod(mg.getMethod());
        this.provider.getInstructionList().dispose(); // Allow instruction handles to be reused
        cg.addEmptyConstructor(Constants.ACC_PUBLIC);

        try {
            cg.getJavaClass().dump(this.name + ".class");
        } catch (java.io.IOException e) {
            System.err.println(e);
        }
    }

    @Override
    public BlockType getType() {
        return this.expression.getType();
    }
}
