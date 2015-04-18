package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.IOutputManager;
import com.jpbnetsoftware.fdbscript.compiler.generator.*;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.BytecodeProvider;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.ClassGenerator;

import java.util.List;

/**
 * Created by pawel on 05/04/15.
 */
public class JvmGenerator implements IGenerator {

    private IOutputManager outputManager;

    public JvmGenerator(IOutputManager outputManager) {
        this.outputManager = outputManager;
    }

    @Override
    public ICodeBlock generateModule(String name, List<ICodeBlock> assignments, ICodeBlock expression) {
        return new ModuleCodeBlock(this.outputManager, name, assignments, expression);
    }

    @Override
    public ICodeBlock generateFunction(List<IDefinitionCodeBlock> arguments, List<ICodeBlock> definitions, ICodeBlock expression) {

        // TODO: class name generator
        String functionClassName = "FunctionXXX";
        ClassGenerator classGenerator = ClassGenerator.beginClass(functionClassName);
        BytecodeProvider provider = new BytecodeProvider(
                classGenerator.getInstructionList(),
                classGenerator.getInstructionFactory());

        for (ICodeBlock d : definitions) {
            d.emit(provider);
        }

        expression.emit(provider);

        byte[] classContent = classGenerator.endClass();

        try {
            this.outputManager.append(functionClassName, classContent);
        } catch (Exception e) {
            //TODO: handle error
            e.printStackTrace();
        }

        return new FunctionCodeBlock(functionClassName, arguments);
    }

    @Override
    public IDefinitionCodeBlock generateArgumentDefinition(String name) {
        return new ArgumentDefinitionCodeBlock(name);
    }

    @Override
    public ICodeBlock generateInvoke(IDefinitionCodeBlock definition, List<ICodeBlock> arguments) {
        return new InvokeCodeBlock(definition, arguments);
    }

    @Override
    public ICodeBlock generateIf(List<ICodeBlock> conditions, ICodeBlock elseExpression) {
        return new IfCodeBlock(conditions, elseExpression);
    }

    @Override
    public ICodeBlock generateCondition(ICodeBlock booleanExpression, ICodeBlock expression) {
        return new ConditionCodeBlock(booleanExpression, expression);
    }

    @Override
    public ICodeBlock generateElse(ICodeBlock expression) {
        return new ElseCodeBlock(expression);
    }

    @Override
    public IDefinitionCodeBlock generateDefinition(String name, ICodeBlock expression) {
        return new DefinitionCodeBlock(name, expression);
    }

    @Override
    public ICodeBlock generateDefinitionInvoke(IDefinitionCodeBlock definition) {
        return new DefinitionInvokeCodeBlock(definition);
    }

    @Override
    public ICodeBlock generateBoolean(ICodeBlock lhs, BooleanOperation operation, ICodeBlock rhs) {
        return new BooleanCodeBlock(lhs, operation, rhs);
    }

    @Override
    public ICodeBlock generateBoolPrimitive(boolean value) {
        return new BoolPrimitiveCodeBlock(value);
    }

    @Override
    public ICodeBlock generateCompare(ICodeBlock lhs, CompareOperation operation, ICodeBlock rhs) {
        return new CompareCodeBlock(lhs, operation, rhs);
    }

    @Override
    public ICodeBlock generateString(String text) {
        return new StringCodeBlock(text);
    }

    @Override
    public ICodeBlock generateMath(ICodeBlock lhs, MathOperation operation, ICodeBlock rhs) {
        return new MathCodeBlock(lhs, operation, rhs);
    }

    @Override
    public ICodeBlock generateNumber(double number) {
        return new NumberCodeBlock(number);
    }
}
