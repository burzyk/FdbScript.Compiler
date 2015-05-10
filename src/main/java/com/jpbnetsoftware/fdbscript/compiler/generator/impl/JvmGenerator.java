package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.IOutputManager;
import com.jpbnetsoftware.fdbscript.compiler.generator.*;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.BytecodeProvider;
import com.jpbnetsoftware.fdbscript.compiler.generator.impl.helpers.ClassGenerator;
import org.apache.bcel.generic.Type;

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

        return new NewObjectCodeBlock(functionClassName);
    }

    @Override
    public ICodeBlock generateInvoke(ICodeBlock definitionInvoke, List<ICodeBlock> arguments) {
        return new RuntimeCallCodeBlock(
                "invoke",
                new GetContextCodeBlock(),
                definitionInvoke,
                new ArrayCodeBlock(Type.OBJECT, arguments));
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

        return new RuntimeCallCodeBlock(
                "index",
                new EmptyCodeBlock(),
                first == null ? new NullCodeBlock() : first,
                second == null ? new NullCodeBlock() : second,
                new BoolPrimitiveCodeBlock(!separatorPresent));
    }

    @Override
    public ICodeBlock generateListAccess(ICodeBlock listSource, List<ICodeBlock> indexExpressions) {
        return new AggregateCodeBlock(
                listSource,
                new AggregateCodeBlock(indexExpressions.toArray(new ICodeBlock[indexExpressions.size()])));
    }

    @Override
    public ICodeBlock generateDefinition(String name, ICodeBlock expression) {
        return new RuntimeCallCodeBlock("defineValue", new GetContextCodeBlock(), new StringCodeBlock(name), expression);
    }

    @Override
    public ICodeBlock generateDefinitionInvoke(String definition) {
        return new RuntimeCallCodeBlock("getValue", new GetContextCodeBlock(), new StringCodeBlock(definition));
    }

    @Override
    public ICodeBlock generateBoolean(ICodeBlock lhs, BooleanOperation operation, ICodeBlock rhs) {

        switch (operation) {
            case And:
                return new RuntimeCallCodeBlock("and", lhs, rhs);
            case Or:
                return new RuntimeCallCodeBlock("or", lhs, rhs);
        }

        // TODO: exception
        return null;
    }

    @Override
    public ICodeBlock generateBoolPrimitive(boolean value) {
        return new BoolPrimitiveCodeBlock(value);
    }

    @Override
    public ICodeBlock generateCompare(ICodeBlock lhs, CompareOperation operation, ICodeBlock rhs) {

        switch (operation) {
            case GreaterThan:
                return new RuntimeCallCodeBlock("greaterThan", lhs, rhs);
            case LessThan:
                return new RuntimeCallCodeBlock("lessThan", lhs, rhs);
            case GreaterEqual:
                return new RuntimeCallCodeBlock("greaterEqual", lhs, rhs);
            case LessEqual:
                return new RuntimeCallCodeBlock("lessEqual", lhs, rhs);
            case Equal:
                return new RuntimeCallCodeBlock("isEqual", lhs, rhs);
            case NotEqual:
                return new RuntimeCallCodeBlock("isNotEqual", lhs, rhs);
        }

        // TODO: error handling
        return null;
    }

    @Override
    public ICodeBlock generateString(String text) {
        return new StringCodeBlock(text);
    }

    @Override
    public ICodeBlock generateMath(ICodeBlock lhs, MathOperation operation, ICodeBlock rhs) {

        switch (operation) {
            case Plus:
                return new RuntimeCallCodeBlock("add", lhs, rhs);
            case Minus:
                return new RuntimeCallCodeBlock("sub", lhs, rhs);
            case Mul:
                return new RuntimeCallCodeBlock("mul", lhs, rhs);
            case Div:
                return new RuntimeCallCodeBlock("div", lhs, rhs);
        }

        // TODO: exception
        return null;
    }

    @Override
    public ICodeBlock generateNumber(double number) {
        return new NumberCodeBlock(number);
    }

    @Override
    public ICodeBlock generateListConcat(ICodeBlock lhs, ICodeBlock rhs) {
        return new RuntimeCallCodeBlock("listConcat", lhs, rhs);
    }

    @Override
    public ICodeBlock generateObject(Map<String, ICodeBlock> members) {
        ICodeBlock[] initializers = new ICodeBlock[members.size()];
        Object[] keys = members.keySet().toArray();

        for (int i = 0; i < members.size(); i++) {
            String key = (String) keys[i];
            ICodeBlock value = members.get(key);

            initializers[i] = new RuntimeCallCodeBlock(
                    "extendObject",
                    new EmptyCodeBlock(),
                    new StringCodeBlock(key),
                    value);
        }

        return new AggregateCodeBlock(new RuntimeCallCodeBlock("createObject"), new AggregateCodeBlock(initializers));
    }

    @Override
    public ICodeBlock generateMemberAccess(ICodeBlock valueSource, List<String> ids) {
        return new MemberAccessCodeBlock(valueSource, ids);
    }
}
