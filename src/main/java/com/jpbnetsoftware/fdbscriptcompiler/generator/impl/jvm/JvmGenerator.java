package com.jpbnetsoftware.fdbscriptcompiler.generator.impl.jvm;

import com.jpbnetsoftware.fdbscriptcompiler.generator.*;

import java.util.List;

/**
 * Created by pawel on 05/04/15.
 */
public class JvmGenerator implements IGenerator {

    private BytecodeProvider provider;

    public JvmGenerator() {
        this.provider = new BytecodeProvider();
    }

    @Override
    public ICodeBlock generateModule(String name, List<ICodeBlock> assignments, ICodeBlock expression) {
        return new ModuleCodeBlock(this.provider, name, assignments, expression);
    }

    @Override
    public ICodeBlock generateFunction(List<ICodeBlock> assignments, ICodeBlock expression) {
        return null;
    }

    @Override
    public IDefinitionCodeBlock generateArgumentDefinition(String name) {
        return null;
    }

    @Override
    public IDefinitionCodeBlock generateSelfDefinition() {
        return null;
    }

    @Override
    public ICodeBlock generateInvoke(IDefinitionCodeBlock definition, List<ICodeBlock> arguments) {
        return null;
    }

    @Override
    public ICodeBlock generateIf(List<ICodeBlock> conditions, ICodeBlock elseExpression) {
        return null;
    }

    @Override
    public ICodeBlock generateCondition(ICodeBlock booleanExpression, ICodeBlock expression) {
        return null;
    }

    @Override
    public ICodeBlock generateElse(ICodeBlock expression) {
        return null;
    }

    @Override
    public IDefinitionCodeBlock generateDefinition(String name, ICodeBlock expression) {
        return null;
    }

    @Override
    public ICodeBlock generateDefinitionInvoke(IDefinitionCodeBlock definition) {
        return null;
    }

    @Override
    public ICodeBlock generateBoolean(ICodeBlock lhs, BooleanOperation operation, ICodeBlock rhs) {
        return null;
    }

    @Override
    public ICodeBlock generateEqualityTest(ICodeBlock lhs, boolean testEqual, ICodeBlock rhs) {
        return null;
    }

    @Override
    public ICodeBlock generateBoolPrimitive(boolean value) {
        return null;
    }

    @Override
    public ICodeBlock generateCompare(ICodeBlock lhs, CompareOperation operation, ICodeBlock rhs) {
        return new CompareCodeBlock(this.provider, lhs, operation, rhs);
    }

    @Override
    public ICodeBlock generateStringConcat(ICodeBlock lhs, ICodeBlock rhs) {
        return new StringConcatCodeBlock(this.provider, lhs, rhs);
    }

    @Override
    public ICodeBlock generateString(String text) {
        return new StringCodeBlock(this.provider, text);
    }

    @Override
    public ICodeBlock generateMath(ICodeBlock lhs, MathOperation operation, ICodeBlock rhs) {
        return new MathCodeBlock(this.provider, lhs, operation, rhs);
    }

    @Override
    public ICodeBlock generateNumber(double number) {
        return new NumberCodeBlock(this.provider, number);
    }
}
