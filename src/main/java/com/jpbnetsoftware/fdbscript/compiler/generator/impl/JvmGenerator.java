package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.IOutputManager;
import com.jpbnetsoftware.fdbscript.compiler.generator.*;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.BytecodeProvider;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.ClassGenerator;

import java.util.List;
import java.util.Map;

/**
 * Created by pawel on 05/04/15.
 */
public class JvmGenerator implements IGenerator {

    private IOutputManager outputManager;

    private int functionCounter = 0;

    public JvmGenerator(IOutputManager outputManager) {
        this.outputManager = outputManager;
    }

    @Override
    public ICodeBlock generateModule(String name, List<ICodeBlock> assignments, ICodeBlock expression) {
        return new ModuleCodeBlock(this.outputManager, name, assignments, expression);
    }

    @Override
    public ICodeBlock generateFunction(List<String> arguments, List<ICodeBlock> definitions, ICodeBlock expression) {

        String functionClassName = "Function_" + this.functionCounter++;
        String[] argumentNames = new String[arguments.size()];
        int i = 0;

        for (String argument : arguments) {
            argumentNames[i++] = argument;
        }

        ClassGenerator classGenerator = ClassGenerator.beginClass(functionClassName, argumentNames);
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

        return new FunctionCodeBlock(functionClassName);
    }

    @Override
    public ICodeBlock generateInvoke(ICodeBlock definitionInvoke, List<ICodeBlock> arguments) {
        return new InvokeCodeBlock(definitionInvoke, arguments);
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
    public ICodeBlock generateList(List<ICodeBlock> initValues) {
        return new ListCodeBlock(initValues);
    }

    @Override
    public ICodeBlock generateIndex(ICodeBlock first, ICodeBlock second, boolean separatorPresent) {
        return new IndexCodeBlock(first, second, separatorPresent);
    }

    @Override
    public ICodeBlock generateListAccess(ICodeBlock listSource, List<ICodeBlock> indexExpressions) {
        return new ListAccessCodeBlock(listSource, indexExpressions);
    }

    @Override
    public ICodeBlock generateDefinition(String name, ICodeBlock expression) {
        return new DefinitionCodeBlock(name, expression);
    }

    @Override
    public ICodeBlock generateDefinitionInvoke(String definition) {
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

    @Override
    public ICodeBlock generateListConcat(ICodeBlock lhs, ICodeBlock rhs) {
        return new ListConcatCodeBlock(lhs, rhs);
    }

    @Override
    public ICodeBlock generateObject(Map<String, ICodeBlock> members) {
        return new ObjectCodeBlock(members);
    }

    @Override
    public ICodeBlock generateMemberAccess(ICodeBlock valueSource, List<String> ids) {
        return new MemberAccessCodeBlock(valueSource, ids);
    }
}
