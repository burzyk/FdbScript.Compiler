package com.jpbnetsoftware.fdbscriptcompiler;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by pawel on 30/03/15.
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IOException {

        String program = "module Fib\n" +
                " 2 + 2 == 1 + 3";

        byte[] bytecode = Compiler.compileModule(program);
        FileOutputStream w = new FileOutputStream("Fib.class");

        w.write(bytecode);

        System.out.println("Done");
    }
}
