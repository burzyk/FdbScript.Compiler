package com.jpbnetsoftware.fdbscript.compiler.generator.impl.java;

import com.jpbnetsoftware.fdbscript.compiler.generator.BlockType;
import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IDefinitionCodeBlock;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by pawel on 04/04/15.
 */
public class InvokeCodeBlock implements ICodeBlock {

    private IDefinitionCodeBlock definition;

    private List<ICodeBlock> arguments;

    private PrintStream out;

    public InvokeCodeBlock(IDefinitionCodeBlock definition, List<ICodeBlock> arguments, PrintStream out) {
        this.definition = definition;
        this.arguments = arguments;
        this.out = out;
    }

    @Override
    public void emit() {
        this.out.print(definition.getName());
        this.out.print(".invoke(");

        for (ICodeBlock arg : this.arguments) {
            arg.emit();

            if (this.arguments.indexOf(arg) != this.arguments.size() - 1) {
                this.out.print(", ");
            }
        }

        this.out.print(")");
    }

    @Override
    public BlockType getType() {
        return ((FunctionCodeBlock) ((DefinitionCodeBlock) this.definition).getExpression()).getFunctionType();
    }
}
