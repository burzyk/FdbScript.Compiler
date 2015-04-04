package com.jpbnetsoftware.fdbscriptcompiler.generator.impl.java;

import com.jpbnetsoftware.fdbscriptcompiler.generator.ICodeBlock;

import java.io.PrintStream;

/**
 * Created by pawel on 04/04/15.
 */
public class DefinitionCodeBlock implements ICodeBlock {

    private String name;

    private ICodeBlock value;

    private PrintStream out;

    public DefinitionCodeBlock(String name, ICodeBlock value, PrintStream out) {
        this.name = name;
        this.value = value;
        this.out = out;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void emit() {
        this.out.print("var " + name);
        this.out.print(" = ");
        this.value.emit();
        this.out.println(";");
    }
}
