package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.IOutputManager;
import com.jpbnetsoftware.fdbscript.compiler.generator.*;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.ClassGenerator;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.JvmFunctionScope;

import java.util.List;

/**
 * Created by pawel on 05/04/15.
 */
public class JvmGenerator implements IGenerator {

    private IOutputManager outputManager;

    private JvmFunctionScope scope;

    public JvmGenerator(IOutputManager outputManager) {
        this.scope = new JvmFunctionScope(null);
        this.outputManager = outputManager;
    }

    @Override
    public IModuleCodeBlock generateModule(String name, List<ICodeBlock> assignments, ICodeBlock expression) {
        return new ModuleCodeBlock(this.scope.getProvider(), name, assignments, expression);
    }

    @Override
    public void beginGenerateFunction() {
        String functionClassName = "FunctionXXX";
        ClassGenerator classGenerator = ClassGenerator.beginClass(functionClassName);

        this.scope = new JvmFunctionScope(this.scope);

        this.scope.getProvider().setInstructionFactory(classGenerator.getInstructionFactory());
        this.scope.getProvider().setInstructionList(classGenerator.getInstructionList());
        this.scope.setClassGenerator(classGenerator);
        this.scope.setFunctionClassName(functionClassName);
    }

    @Override
    public ICodeBlock generateFunction(List<ICodeBlock> argumentDefinitions, List<ICodeBlock> definitions, ICodeBlock expression) {

        // TODO: class name generator
        ClassGenerator classGenerator = this.scope.getClassGenerator();
        String functionClassName = this.scope.getFunctionClassName();

        for (ICodeBlock d : argumentDefinitions) {
            d.emit();
        }

        for (ICodeBlock d : definitions) {
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

        this.scope = this.scope.getParent();

        return new FunctionCodeBlock(this.scope.getProvider(), functionClassName);
    }

    @Override
    public IDefinitionCodeBlock generateArgumentDefinition(String name) {
        return new ArgumentDefinitionCodeBlock(
                this.scope.getProvider(),
                1,
                this.scope.getNextArgumentId(),
                this.scope.getNextVariableId(),
                name);
    }

    @Override
    public IDefinitionCodeBlock generateSelfDefinition() {
        return new SelfDefinitionCodeBlock(this.scope.getProvider(), 0, "self");
    }

    @Override
    public ICodeBlock generateInvoke(IDefinitionCodeBlock definition, List<ICodeBlock> arguments) {
        return new InvokeCodeBlock(this.scope.getProvider(), this.scope.getNextVariableId(), definition, arguments);
    }

    @Override
    public ICodeBlock generateIf(List<ICodeBlock> conditions, ICodeBlock elseExpression) {
        return new IfCodeBlock(this.scope.getProvider(), conditions, elseExpression);
    }

    @Override
    public ICodeBlock generateCondition(ICodeBlock booleanExpression, ICodeBlock expression) {
        return new ConditionCodeBlock(this.scope.getProvider(), booleanExpression, expression);
    }

    @Override
    public ICodeBlock generateElse(ICodeBlock expression) {
        return new ElseCodeBlock(expression);
    }

    @Override
    public IDefinitionCodeBlock generateDefinition(String name, ICodeBlock expression) {
        return new DefinitionCodeBlock(this.scope.getProvider(), this.scope.getNextVariableId(), name, expression);
    }

    @Override
    public ICodeBlock generateDefinitionInvoke(IDefinitionCodeBlock definition) {
        return new DefinitionInvokeCodeBlock(this.scope.getProvider(), definition);
    }

    @Override
    public ICodeBlock generateBoolean(ICodeBlock lhs, BooleanOperation operation, ICodeBlock rhs) {
        return new BooleanCodeBlock(this.scope.getProvider(), lhs, operation, rhs);
    }

    @Override
    public ICodeBlock generateEqualityTest(ICodeBlock lhs, boolean testEqual, ICodeBlock rhs) {
        return new EqualityTestCodeBlock(this.scope.getProvider(), lhs, testEqual, rhs);
    }

    @Override
    public ICodeBlock generateBoolPrimitive(boolean value) {
        return new BoolPrimitiveCodeBlock(this.scope.getProvider(), value);
    }

    @Override
    public ICodeBlock generateCompare(ICodeBlock lhs, CompareOperation operation, ICodeBlock rhs) {
        return new CompareCodeBlock(this.scope.getProvider(), lhs, operation, rhs);
    }

    @Override
    public ICodeBlock generateStringConcat(ICodeBlock lhs, ICodeBlock rhs) {
        return new StringConcatCodeBlock(this.scope.getProvider(), lhs, rhs);
    }

    @Override
    public ICodeBlock generateString(String text) {
        return new StringCodeBlock(this.scope.getProvider(), text);
    }

    @Override
    public ICodeBlock generateMath(ICodeBlock lhs, MathOperation operation, ICodeBlock rhs) {
        return new MathCodeBlock(this.scope.getProvider(), lhs, operation, rhs);
    }

    @Override
    public ICodeBlock generateNumber(double number) {
        return new NumberCodeBlock(this.scope.getProvider(), number);
    }
}
