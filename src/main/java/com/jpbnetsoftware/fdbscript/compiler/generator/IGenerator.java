package com.jpbnetsoftware.fdbscript.compiler.generator;

import java.util.List;

/**
 * Created by pawel on 03/04/15.
 */
public interface IGenerator {

    ICodeBlock generateModule(String name, List<ICodeBlock> assignments, ICodeBlock expression);

    ICodeBlock generateFunction(List<IDefinitionCodeBlock> arguments, List<ICodeBlock> definitions, ICodeBlock expression);

    IDefinitionCodeBlock generateArgumentDefinition(String name);

    ICodeBlock generateInvoke(String functionName, List<ICodeBlock> arguments);

    ICodeBlock generateIf(List<ICodeBlock> conditions, ICodeBlock elseExpression);

    ICodeBlock generateCondition(ICodeBlock booleanExpression, ICodeBlock expression);

    ICodeBlock generateElse(ICodeBlock expression);

    IDefinitionCodeBlock generateDefinition(String name, ICodeBlock expression);

    IDefinitionCodeBlock generateSelfDefinition();

    ICodeBlock generateDefinitionInvoke(IDefinitionCodeBlock definition);

    ICodeBlock generateBoolean(ICodeBlock lhs, BooleanOperation operation, ICodeBlock rhs);

    ICodeBlock generateBoolPrimitive(boolean value);

    ICodeBlock generateCompare(ICodeBlock lhs, CompareOperation operation, ICodeBlock rhs);

    ICodeBlock generateString(String text);

    ICodeBlock generateMath(ICodeBlock lhs, MathOperation operation, ICodeBlock rhs);

    ICodeBlock generateNumber(double number);
}
