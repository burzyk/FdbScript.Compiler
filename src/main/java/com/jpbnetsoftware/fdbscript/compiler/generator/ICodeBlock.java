package com.jpbnetsoftware.fdbscriptcompiler.generator;

/**
 * Created by pawel on 03/04/15.
 */
public interface ICodeBlock {

    void emit();

    BlockType getType();
}
