package com.jpbnetsoftware.fdbscript.compiler.impl;

import com.jpbnetsoftware.fdbscript.compiler.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by pawel on 10/04/15.
 */
public class FileOutputManager implements IOutputManager {

    @Override
    public void append(String name, byte[] content) throws Exception {
        FileOutputStream w = new FileOutputStream(name + ".class");
        w.write(content);
    }
}
