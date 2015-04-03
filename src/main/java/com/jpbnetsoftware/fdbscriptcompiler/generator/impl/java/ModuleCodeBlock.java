package com.jpbnetsoftware.fdbscriptcompiler.generator.impl.java;

import com.jpbnetsoftware.fdbscriptcompiler.generator.ICodeBlock;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by pawel on 03/04/15.
 */
public class ModuleCodeBlock implements ICodeBlock {

    private String name;

    private List<ICodeBlock> assignments;

    private ICodeBlock expression;

    private PrintStream out;

    public ModuleCodeBlock(String name, List<ICodeBlock> assignments, ICodeBlock expression, PrintStream out) {
        this.name = name;
        this.assignments = assignments;
        this.expression = expression;
        this.out = out;
    }

    @Override
    public void emit() {

        this.out.println("class " + this.name + " {");
        this.out.println("    public Object main() {");

        for (ICodeBlock cb : this.assignments) {
            cb.emit();
        }

        this.out.print("        return ");
        this.expression.emit();
        this.out.println(";");
        this.out.println("    }");
        this.out.println("}");
    }
}
