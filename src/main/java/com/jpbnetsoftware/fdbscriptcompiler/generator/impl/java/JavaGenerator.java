package com.jpbnetsoftware.fdbscriptcompiler.generator.impl.java;

import com.jpbnetsoftware.fdbscriptcompiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscriptcompiler.generator.IGenerator;
import com.jpbnetsoftware.fdbscriptcompiler.generator.MathOperation;

import java.util.List;

/**
 * Created by pawel on 03/04/15.
 */
public class JavaGenerator implements IGenerator {

    @Override
    public ICodeBlock generateModule(String name, List<ICodeBlock> assignments, ICodeBlock expression) {
        return new ModuleCodeBlock(name, assignments, expression, System.out);
    }

    @Override
    public ICodeBlock generateStringConcat(ICodeBlock lhs, ICodeBlock rhs) {
        return new StringConcatCodeBlock(lhs, rhs, System.out);
    }

    @Override
    public ICodeBlock generateString(String text) {
        return new StringCodeBock(text, System.out);
    }

    @Override
    public ICodeBlock generateMath(ICodeBlock lhs, MathOperation operation, ICodeBlock rhs) {
        return new MathCodeBlock(lhs, operation, rhs, System.out);
    }

    @Override
    public ICodeBlock generateNumber(float number) {
        return new NumberCodeBlock(number, System.out);
    }
}
