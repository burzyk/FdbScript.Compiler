package com.jpbnetsoftware.fdbscriptcompiler.generator;

import java.util.List;

/**
 * Created by pawel on 03/04/15.
 */
public interface IGenerator {

    ICodeBlock generateModule(String name, List<ICodeBlock> assignments, ICodeBlock expression);

    ICodeBlock generateFunction(List<ICodeBlock> assignments, ICodeBlock expression);

    IDefinitionCodeBlock generateArgumentDefinition(String name);

    IDefinitionCodeBlock generateSelfDefinition();

    ICodeBlock generateInvoke(IDefinitionCodeBlock definition, List<ICodeBlock> arguments);

    ICodeBlock generateIf(List<ICodeBlock> conditions, ICodeBlock elseExpression);

    ICodeBlock generateCondition(ICodeBlock booleanExpression, ICodeBlock expression);

    ICodeBlock generateElse(ICodeBlock expression);

    IDefinitionCodeBlock generateDefinition(String name, ICodeBlock expression);

    ICodeBlock generateDefinitionInvoke(IDefinitionCodeBlock definition);

    ICodeBlock generateBoolean(ICodeBlock lhs, BooleanOperation operation, ICodeBlock rhs);

    ICodeBlock generateEqualityTest(ICodeBlock lhs, boolean testEqual, ICodeBlock rhs);

    ICodeBlock generateBoolPrimitive(boolean value);

    ICodeBlock generateCompare(ICodeBlock lhs, CompareOperation operation, ICodeBlock rhs);

    ICodeBlock generateStringConcat(ICodeBlock lhs, ICodeBlock rhs);

    ICodeBlock generateString(String text);

    ICodeBlock generateMath(ICodeBlock lhs, MathOperation operation, ICodeBlock rhs);

    ICodeBlock generateNumber(float number);
}
