package uk.co.directline.mathcompiler;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.apache.bcel.Constants;
import org.apache.bcel.generic.*;
import uk.co.directline.mathcompiler.antlr.CalcLexer;
import uk.co.directline.mathcompiler.antlr.CalcParser;
import uk.co.directline.mathcompiler.operations.BaseOperation;
import uk.co.directline.mathcompiler.operations.LoadValueOperaiton;
import uk.co.directline.mathcompiler.operations.PlusOperation;

import java.util.List;


/**
 * Created by pawel on 30/03/15.
 */
public class Main {
    public static void main(String [] args) throws ClassNotFoundException {

        CalcEmitListener listener = new CalcEmitListener();
        CharStream input = new ANTLRInputStream(" 12 + 7 * 6 / 13 - 7 * 9");
        CalcLexer lexer = new CalcLexer(input);
        TokenStream tokens = new CommonTokenStream(lexer);
        CalcParser parser = new CalcParser(tokens);
        parser.addParseListener(listener);
        parser.expr();

        generateBytecode(listener.getOperations());

        System.out.println("Done");
    }

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
}
