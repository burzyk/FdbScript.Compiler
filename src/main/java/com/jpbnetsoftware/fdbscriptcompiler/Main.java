package com.jpbnetsoftware.fdbscriptcompiler;

import com.jpbnetsoftware.fdbscriptcompiler.antlr.FdbScriptLexer;
import com.jpbnetsoftware.fdbscriptcompiler.antlr.FdbScriptParser;
import com.jpbnetsoftware.fdbscriptcompiler.generator.impl.jvm.JvmGenerator;
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
                " ((2 + 2 ) * 2) + \" ala \" + \"ma kota \" + (2 + 2 * 2)";


        FdbScriptAstVisitor visitor = new FdbScriptAstVisitor(new JvmGenerator());
        CharStream input = new ANTLRInputStream(program);
        FdbScriptLexer lexer = new FdbScriptLexer(input);
        TokenStream tokens = new CommonTokenStream(lexer);
        FdbScriptParser parser = new FdbScriptParser(tokens);

        visitor.visit(parser.programDeclaration()).emit();

        System.out.println("Done");
    }
}
