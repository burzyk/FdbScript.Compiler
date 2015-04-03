package com.jpbnetsoftware.fdbscriptcompiler;

/**
 * Created by pawel on 30/03/15.
 */
public class Main {
    public static void main(String [] args) throws ClassNotFoundException {

        /*
        CalcEmitListener listener = new CalcEmitListener();
        FdbScriptAstVisitor visitor = new FdbScriptAstVisitor();
        CharStream input = new ANTLRInputStream(" 2 + 2 * 2");
        CalcLexer lexer = new CalcLexer(input);
        TokenStream tokens = new CommonTokenStream(lexer);
        CalcParser parser = new CalcParser(tokens);
        //parser.addParseListener(listener);


        visitor.visit(parser.expr());

        generateBytecode(visitor.getOperations());

        System.out.println("Done");
        */
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
