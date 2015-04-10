package com.jpbnetsoftware.fdbscript.compiler;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by pawel on 10/04/15.
 */
public interface IOutputManager {
    void append(String name, byte[] content) throws Exception;
}
