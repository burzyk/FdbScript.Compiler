package com.jpbnetsoftware.fdbscriptcompiler.generator.impl.java;

import com.jpbnetsoftware.fdbscriptcompiler.generator.BlockType;
import com.jpbnetsoftware.fdbscriptcompiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscriptcompiler.generator.IDefinitionCodeBlock;

import java.io.PrintStream;

/**
 * Created by pawel on 04/04/15.
 */
public class DefinitionCodeBlock implements IDefinitionCodeBlock {

    private String name;

    private ICodeBlock expression;

    private PrintStream out;

    public DefinitionCodeBlock(String name, ICodeBlock expression, PrintStream out) {
        this.name = name;
        this.expression = expression;
        this.out = out;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void emit() {
        this.out.print(BlockTypeTranslator.getJavaTypeName(this.getType()) + " " + name);
        this.out.print(" = ");
        this.expression.emit();
        this.out.println(";");
    }

    @Override
    public BlockType getType() {
        return this.expression.getType();
    }
}
