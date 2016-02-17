package com.jpbnetsoftware.fdbscript.compiler.impl;

import com.jpbnetsoftware.fdbscript.compiler.*;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

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
