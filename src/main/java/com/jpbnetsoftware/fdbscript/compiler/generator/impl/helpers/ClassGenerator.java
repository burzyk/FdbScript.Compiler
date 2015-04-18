package com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers;

import org.apache.bcel.Constants;
import org.apache.bcel.classfile.Field;
import org.apache.bcel.generic.*;

/**
 * Created by pawel on 10/04/15.
 */
public class ClassGenerator {

    private ConstantPoolGen constantPoolGen;

    private InstructionList instructionList;

    private InstructionFactory instructionFactory;

    private ClassGen moduleClass;

    private MethodGen methodGen;

    private ClassGenerator() {
    }

    public static ClassGenerator beginClass(String name, String[] argumentNames) {
        ClassGenerator generator = new ClassGenerator();

        generator.moduleClass = new ClassGen(
                name,
                "java.lang.Object",
                "<generated>",
                Constants.ACC_PUBLIC | Constants.ACC_SUPER,
                new String[]{"com.jpbnetsoftware.fdbscript.runtime.IInvokable"});

        generator.constantPoolGen = generator.moduleClass.getConstantPool();
        generator.instructionList = new InstructionList();

        generator.methodGen = new MethodGen(
                Constants.ACC_PUBLIC, // access flags
                Type.OBJECT,               // return type
                new Type[]{new ObjectType("com.jpbnetsoftware.fdbscript.runtime.InvokeContext")},
                new String[]{"context"}, // arg names
                "invoke",
                name,    // method, class
                generator.instructionList,
                generator.constantPoolGen);

        generator.instructionFactory = new InstructionFactory(generator.moduleClass);

        createGetArgumentsMethod(generator.moduleClass, argumentNames);

        return generator;
    }

    private static void createGetArgumentsMethod(ClassGen moduleClass, String[] argumentNames) {

        InstructionList il = new InstructionList();
        InstructionFactory factory = new InstructionFactory(moduleClass);

        MethodGen method = new MethodGen(
                Constants.ACC_PUBLIC,
                new ArrayType(Type.STRING, 1),
                new Type[]{},
                new String[]{},
                "getArguments",
                moduleClass.getClassName(),
                il,
                moduleClass.getConstantPool());

        il.append(factory.createConstant(argumentNames.length));
        il.append(factory.createNewArray(Type.STRING, (short) 1));
        il.append(new ASTORE(1));
        int i = 0;

        for (String s : argumentNames) {
            il.append(new ALOAD(1));
            il.append(factory.createConstant(i++));
            il.append(factory.createConstant(s));
            il.append(new AASTORE());
        }

        il.append(new ALOAD(1));
        il.append(InstructionConstants.ARETURN);

        method.setMaxStack();
        method.setMaxLocals();
        moduleClass.addMethod(method.getMethod());
        il.dispose(); // Allow instruction handles to be reused
    }

    public byte[] endClass() {

        this.instructionList.append(InstructionConstants.ARETURN);

        this.methodGen.setMaxStack();
        this.methodGen.setMaxLocals();
        this.moduleClass.addMethod(this.methodGen.getMethod());
        this.instructionList.dispose(); // Allow instruction handles to be reused
        this.moduleClass.addEmptyConstructor(Constants.ACC_PUBLIC);

        return this.moduleClass.getJavaClass().getBytes();
    }

    public InstructionFactory getInstructionFactory() {
        return instructionFactory;
    }

    public InstructionList getInstructionList() {
        return instructionList;
    }
}
