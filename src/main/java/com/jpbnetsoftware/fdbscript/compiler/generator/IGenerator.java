package com.jpbnetsoftware.fdbscript.compiler.generator;

import java.util.List;

/**
 * Created by pawel on 03/04/15.
 */
public interface IGenerator {

    IModuleCodeBlock generateModule(String name, List<ICodeBlock> assignments, ICodeBlock expression);

    void beginGenerateFunction();

    ICodeBlock generateFunction(List<ICodeBlock> argumentDefinitions, List<ICodeBlock> definitions, ICodeBlock expression);

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

    ICodeBlock generateNumber(double number);
}
