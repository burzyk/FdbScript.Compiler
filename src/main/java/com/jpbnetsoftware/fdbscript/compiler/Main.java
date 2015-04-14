package com.jpbnetsoftware.fdbscript.compiler;

import com.jpbnetsoftware.fdbscript.compiler.impl.FileOutputManager;

/**
 * Created by pawel on 30/03/15.
 */
public class Main {
    public static void main(String[] args) throws Exception {

        String program = "module Fib\n" +
                " x = 9" +
                " z = 8" +
                "" +
                " (x + z == 3) -> 4" +
                " (x + z == 17) -> 5" +
                " _ -> 10";

        Compiler.compileModule(program, new FileOutputManager());

        System.out.println("Done");
    }
}
