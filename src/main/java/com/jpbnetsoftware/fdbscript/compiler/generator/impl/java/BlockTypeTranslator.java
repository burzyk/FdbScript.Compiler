package com.jpbnetsoftware.fdbscript.compiler.generator.impl.java;

import com.jpbnetsoftware.fdbscript.compiler.generator.BlockType;

/**
 * Created by pawel on 04/04/15.
 */
public class BlockTypeTranslator {

    public static String getJavaTypeName(BlockType type) {
        switch (type) {
            case Boolean:
                return "boolean";
            case Number:
                return "double";
            case String:
                return "String";
            case Function:
                return "IFunction";
            case Any:
                return "Object";
        }

        return "Object";
    }
}