package com.jpbnetsoftware.fdbscript.compiler.generator.impl.jvm;

import com.jpbnetsoftware.fdbscript.compiler.IOutputManager;
import com.jpbnetsoftware.fdbscript.compiler.generator.*;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.jvm.helpers.BytecodeProvider;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.jvm.helpers.ClassGenerator;

import java.util.List;

/**
 * Created by pawel on 05/04/15.
 */
public class JvmGenerator implements IGenerator {

    private BytecodeProvider provider;

    private IOutputManager outputManager;

    // Java uses stack to pass parameters to any method
    // first parameter is 'this', second parameter is always array of objects from IInvokable
    private int nextVariableId = 2;

    public JvmGenerator(IOutputManager outputManager) {
        this.provider = new BytecodeProvider();
        this.outputManager = outputManager;
    }

    @Override
    public IModuleCodeBlock generateModule(String name, List<ICodeBlock> assignments, ICodeBlock expression) {
        return new ModuleCodeBlock(this.provider, name, assignments, expression);
    }

    @Override
    public ICodeBlock generateFunction(List<ICodeBlock> assignments, ICodeBlock expression) {

        // TODO: class name generator

        String functionClassName = "FunctionXXX";
        ClassGenerator classGenerator = ClassGenerator.beginClass(functionClassName);
        BytecodeProvider parentProvider = this.provider;

        this.provider = new BytecodeProvider();

        this.provider.setInstructionFactory(classGenerator.getInstructionFactory());
        this.provider.setInstructionList(classGenerator.getInstructionList());

        for (ICodeBlock d : assignments) {
            d.emit();
        }

        expression.emit();

        byte[] classContent = classGenerator.endClass();

        try {
            this.outputManager.append(functionClassName, classContent);
        } catch (Exception e) {
            //TODO: handle error
            e.printStackTrace();
        }

        this.provider = parentProvider;

        return new FunctionCodeBlock(this.provider, functionClassName, expression.getType());
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
        return new IfCodeBlock(this.provider, conditions, elseExpression);
    }

    @Override
    public ICodeBlock generateCondition(ICodeBlock booleanExpression, ICodeBlock expression) {
        return new ConditionCodeBlock(this.provider, booleanExpression, expression);
    }

    @Override
    public ICodeBlock generateElse(ICodeBlock expression) {
        return new ElseCodeBlock(expression);
    }

    @Override
    public IDefinitionCodeBlock generateDefinition(String name, ICodeBlock expression) {
        return new DefinitionCodeBlock(this.provider, this.nextVariableId++, name, expression);
    }

    @Override
    public ICodeBlock generateDefinitionInvoke(IDefinitionCodeBlock definition) {
        return new DefinitionInvokeCodeBlock(this.provider, definition);
    }

    @Override
    public ICodeBlock generateBoolean(ICodeBlock lhs, BooleanOperation operation, ICodeBlock rhs) {
        return new BooleanCodeBlock(this.provider, lhs, operation, rhs);
    }

    @Override
    public ICodeBlock generateEqualityTest(ICodeBlock lhs, boolean testEqual, ICodeBlock rhs) {
        return new EqualityTestCodeBlock(this.provider, lhs, testEqual, rhs);
    }

    @Override
    public ICodeBlock generateBoolPrimitive(boolean value) {
        return new BoolPrimitiveCodeBlock(this.provider, value);
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
