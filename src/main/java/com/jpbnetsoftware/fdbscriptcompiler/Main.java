package com.jpbnetsoftware.fdbscriptcompiler;

import com.jpbnetsoftware.fdbscriptcompiler.antlr.FdbScriptLexer;
import com.jpbnetsoftware.fdbscriptcompiler.antlr.FdbScriptParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

/**
 * Created by pawel on 30/03/15.
 */
public class Main {
    public static void main(String [] args) throws ClassNotFoundException {

        String program = "module Fib\n" +
                "\n" +
                "    fibAcc = f(n, acc):\n" +
                "        (n == -0 || n == 7) -> acc\n" +
                "        _ -> fibAcc(n - 1, acc * n)\n" +
                "\n" +
                "    fib = f(n): fibAcc(n, 1)\n" +
                "\n" +
                "    x = fib(10)\n" +
                "\n" +
                "    x()";


        FdbScriptAstVisitor visitor = new FdbScriptAstVisitor();
        CharStream input = new ANTLRInputStream(program);
        FdbScriptLexer lexer = new FdbScriptLexer(input);
        TokenStream tokens = new CommonTokenStream(lexer);
        FdbScriptParser parser = new FdbScriptParser(tokens);

        visitor.visit(parser.programDeclaration());

        System.out.println("Done");
    }

    /*
    public static void generateBytecode(List<BaseOperation> operations) {
        ClassGen cg = new ClassGen(
                "HelloWorld",
                "java.lang.Object",
                "<generated>",
                Constants.ACC_PUBLIC | Constants.ACC_SUPER,
                null);

        ConstantPoolGen cp = cg.getConstantPool(); // cg creates constant pool
        InstructionList il = new InstructionList();

        MethodGen mg = new MethodGen(
                Constants.ACC_STATIC | Constants.ACC_PUBLIC, // access flags
                Type.VOID,               // return type
                new Type[] { new ArrayType(Type.STRING, 1) },
                new String[] { "argv" }, // arg names
                "main",
                "HelloWorld",    // method, class
                il,
                cp);
        InstructionFactory factory = new InstructionFactory(cg);

        il.append(factory.createFieldAccess(
                "java.lang.System",
                "out",
                new ObjectType("java.io.PrintStream"),
                Constants.GETSTATIC));

        for (BaseOperation operation : operations) {
            operation.execute(il, factory);
        }

        il.append(factory.createInvoke(
                "java.lang.Integer",
                "toString",
                Type.STRING, new Type[]{Type.INT},
                Constants.INVOKESTATIC));

        il.append(factory.createInvoke(
                "java.io.PrintStream",
                "println",
                Type.VOID, new Type[]{Type.STRING},
                Constants.INVOKEVIRTUAL));

        il.append(InstructionConstants.RETURN);

        mg.setMaxStack();
        cg.addMethod(mg.getMethod());
        il.dispose(); // Allow instruction handles to be reused
        cg.addEmptyConstructor(Constants.ACC_PUBLIC);

        try {
            cg.getJavaClass().dump("HelloWorld.class");
        } catch(java.io.IOException e) { System.err.println(e); }
    }

    */
}
