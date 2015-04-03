package com.jpbnetsoftware.fdbscriptcompiler.generator;

import java.util.List;

/**
 * Created by pawel on 03/04/15.
 */
public interface IGenerator {

    ICodeBlock generateModule(String name, List<ICodeBlock> assignments, ICodeBlock expression);

    ICodeBlock generateMath(ICodeBlock lhs, MathOperation operation, ICodeBlock rhs);

    ICodeBlock generateNumber(float number);
}
