package com.jpbnetsoftware.fdbscript.compiler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.*;

/**
 * Created by pawel on 30/03/15.
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IOException {

        String program = "module Fib\n" +
                " 2 + 2 * 2 < (2 + 2) * 2";

        byte[] bytecode = Compiler.compileModule(program);
        FileOutputStream w = new FileOutputStream("Fib.class");

        w.write(bytecode);

        System.out.println("Done");
    }
}
