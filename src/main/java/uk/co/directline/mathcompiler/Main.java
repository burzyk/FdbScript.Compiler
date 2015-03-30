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

        ObjectType i_stream = new ObjectType("java.io.InputStream");
        ObjectType p_stream = new ObjectType("java.io.PrintStream");

        il.append(factory.createNew("java.io.BufferedReader"));
        il.append(InstructionConstants.DUP); // Use predefined constant
        il.append(factory.createNew("java.io.InputStreamReader"));
        il.append(InstructionConstants.DUP);
        il.append(factory.createFieldAccess("java.lang.System", "in", i_stream, Constants.GETSTATIC));
        il.append(factory.createInvoke(
                "java.io.InputStreamReader",
                "<init>",
                Type.VOID,
                new Type[] { i_stream },
                Constants.INVOKESPECIAL));
        il.append(factory.createInvoke(
                "java.io.BufferedReader",
                "<init>",
                Type.VOID,
                new Type[] { new ObjectType("java.io.Reader") },
                Constants.INVOKESPECIAL));

        LocalVariableGen lg = mg.addLocalVariable("in", new ObjectType("java.io.BufferedReader"), null, null);
        int in = lg.getIndex();
        lg.setStart(il.append(new ASTORE(in))); // "i" valid from here

        lg = mg.addLocalVariable("name", Type.STRING, null, null);
        int name = lg.getIndex();
        il.append(InstructionConstants.ACONST_NULL);
        lg.setStart(il.append(new ASTORE(name))); // "name" valid from here

        InstructionHandle try_start = il.append(
                factory.createFieldAccess("java.lang.System", "out", p_stream, Constants.GETSTATIC));

        il.append(new PUSH(cp, "Please enter your name> "));
        il.append(factory.createInvoke("java.io.PrintStream", "print", Type.VOID,
                new Type[] { Type.STRING },
                Constants.INVOKEVIRTUAL));
        il.append(new ALOAD(in));
        il.append(factory.createInvoke("java.io.BufferedReader", "readLine",
                Type.STRING, Type.NO_ARGS,
                Constants.INVOKEVIRTUAL));
        il.append(new ASTORE(name));

        GOTO g = new GOTO(null);
        InstructionHandle try_end = il.append(g);

        InstructionHandle handler = il.append(InstructionConstants.RETURN);
        mg.addExceptionHandler(try_start, try_end, handler, new ObjectType("java.io.IOException"));

        InstructionHandle ih =
                il.append(factory.createFieldAccess("java.lang.System", "out", p_stream,
                        Constants.GETSTATIC));
        g.setTarget(ih);


        il.append(factory.createNew(Type.STRINGBUFFER));
        il.append(InstructionConstants.DUP);
        il.append(new PUSH(cp, "Hello, "));
        il.append(factory.createInvoke("java.lang.StringBuffer", "<init>",
                Type.VOID, new Type[] { Type.STRING },
                Constants.INVOKESPECIAL));
        il.append(new ALOAD(name));
        il.append(factory.createInvoke("java.lang.StringBuffer", "append",
                Type.STRINGBUFFER, new Type[] { Type.STRING },
                Constants.INVOKEVIRTUAL));
        il.append(factory.createInvoke("java.lang.StringBuffer", "toString",
                Type.STRING, Type.NO_ARGS,
                Constants.INVOKEVIRTUAL));

        il.append(factory.createInvoke("java.io.PrintStream", "println",
                Type.VOID, new Type[] { Type.STRING },
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
}
