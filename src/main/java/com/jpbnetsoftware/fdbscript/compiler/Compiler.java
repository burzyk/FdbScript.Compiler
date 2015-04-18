package com.jpbnetsoftware.fdbscript.compiler;

import com.jpbnetsoftware.fdbscript.compiler.antlr.FdbScriptLexer;
import com.jpbnetsoftware.fdbscript.compiler.antlr.FdbScriptParser;
import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.JvmGenerator;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

/**
 * Created by pawel on 05/04/15.
 */
public class Compiler {

    public static void compileModule(String moduleCode, IOutputManager outputManager) throws Exception {

        FdbScriptAstVisitor visitor = new FdbScriptAstVisitor(new JvmGenerator(outputManager));
        CharStream input = new ANTLRInputStream(moduleCode);
        FdbScriptLexer lexer = new FdbScriptLexer(input);
        TokenStream tokens = new CommonTokenStream(lexer);
        FdbScriptParser parser = new FdbScriptParser(tokens);

        ICodeBlock module = (ICodeBlock)visitor.visit(parser.programDeclaration());

        module.emit(null);
    }
}
