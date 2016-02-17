package com.jpbnetsoftware.fdbscript.compiler;

import com.jpbnetsoftware.fdbscript.compiler.impl.FileOutputManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by pawel on 30/03/15.
 */
public class Main {
    public static void main(String[] args) throws Exception {

        if (args.length < 1) {
            System.out.println("Missing input or output file");
            return;
        }

        try {
            String fileName = args[0];

            StringBuilder sb = new StringBuilder();
            String line = null;

            BufferedReader fr = new BufferedReader(new FileReader(new File(fileName)));

            while ((line = fr.readLine()) != null) {
                if (!line.startsWith("#")) {
                    sb.append(line.replace('\n', ' ') + " ");
                }
            }

            Compiler.compileModule(sb.toString(), new FileOutputManager());

            System.out.println("Done");
        } catch (Exception ex) {
            return;
        }
    }
}
