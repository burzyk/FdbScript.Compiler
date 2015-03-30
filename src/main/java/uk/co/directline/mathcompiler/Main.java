package uk.co.directline.mathcompiler;

import org.apache.bcel.Constants;
import org.apache.bcel.generic.*;


/**
 * Created by pawel on 30/03/15.
 */
public class Main {
    public static void main(String [] args) throws ClassNotFoundException {

        ClassGen cg = new ClassGen(
                "HelloWorld",
                "java.lang.Object",
                "<generated>",
                Constants.ACC_PUBLIC | Constants.ACC_SUPER,
                null);

        ConstantPoolGen cp = cg.getConstantPool(); // cg creates constant pool
        InstructionList il = new InstructionList();

        int str = cp.addString("Hello World 1");

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

        il.append(new LDC(str));

        il.append(factory.createInvoke(
                "java.io.PrintStream",
                "println",
                Type.VOID, new Type[]{Type.STRING},
                Constants.INVOKEVIRTUAL));

        il.append(factory.createPrintln("Hello World 2"));

        il.append(InstructionConstants.RETURN);

        mg.setMaxStack();
        cg.addMethod(mg.getMethod());
        il.dispose(); // Allow instruction handles to be reused
        cg.addEmptyConstructor(Constants.ACC_PUBLIC);

        try {
            cg.getJavaClass().dump("HelloWorld.class");
        } catch(java.io.IOException e) { System.err.println(e); }
    }
}
