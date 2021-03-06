package com.jpbnetsoftware.fdbscript.compiler.generator;

import java.util.List;
import java.util.Map;

/**
 * Created by pawel on 03/04/15.
 */
public interface IGenerator {

    ICodeBlock generateModule(String name, List<ICodeBlock> assignments, ICodeBlock expression);

    ICodeBlock generateFunction(List<String> arguments, List<ICodeBlock> definitions, ICodeBlock expression);

    ICodeBlock generateInvoke(ICodeBlock definitionInvoke, List<ICodeBlock> arguments);

    ICodeBlock generateIf(List<ICodeBlock> conditions, ICodeBlock elseExpression);

    ICodeBlock generateCondition(ICodeBlock booleanExpression, ICodeBlock expression);

    ICodeBlock generateElse(ICodeBlock expression);

    ICodeBlock generateList(List<ICodeBlock> initValues);

    ICodeBlock generateIndex(ICodeBlock first, ICodeBlock second, boolean separatorPresent);

    ICodeBlock generateListAccess(ICodeBlock listSource, List<ICodeBlock> indexExpressions);

    ICodeBlock generateDefinition(String name, ICodeBlock expression);

    ICodeBlock generateDefinitionInvoke(String definition);

    ICodeBlock generateBoolean(ICodeBlock lhs, BooleanOperation operation, ICodeBlock rhs);

    ICodeBlock generateBoolPrimitive(boolean value);

    ICodeBlock generateCompare(ICodeBlock lhs, CompareOperation operation, ICodeBlock rhs);

    ICodeBlock generateString(String text);

    ICodeBlock generateMath(ICodeBlock lhs, MathOperation operation, ICodeBlock rhs);

    ICodeBlock generateNumber(double number);

    ICodeBlock generateListConcat(ICodeBlock lhs, ICodeBlock rhs);

    ICodeBlock generateObject(Map<String, ICodeBlock> members);

    ICodeBlock generateMemberAccess(ICodeBlock valueSource, List<String> ids);
}
