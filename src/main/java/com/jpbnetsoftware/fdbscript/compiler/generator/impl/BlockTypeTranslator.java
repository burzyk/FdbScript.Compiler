package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.BlockType;
import org.apache.bcel.generic.Type;

/**
 * Created by pawel on 04/04/15.
 */
public class BlockTypeTranslator {

    public static Type getJavaTypeName(BlockType type) {
        switch (type) {
            case Boolean:
                return Type.BOOLEAN;
            case Number:
                return Type.DOUBLE;
            case String:
                return Type.STRING;
            case Function:
                return Type.OBJECT;
            case Any:
                return Type.OBJECT;
        }

        return Type.OBJECT;
    }
}