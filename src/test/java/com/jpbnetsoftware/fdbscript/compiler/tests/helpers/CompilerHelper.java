package com.jpbnetsoftware.fdbscript.compiler.tests.helpers;

import com.jpbnetsoftware.fdbscript.compiler.*;
import com.jpbnetsoftware.fdbscript.compiler.Compiler;
import com.jpbnetsoftware.fdbscript.runtime.IInvokable;
import com.jpbnetsoftware.fdbscript.runtime.InvokeContext;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by pawel on 14/04/15.
 */
public class CompilerHelper {

    public static IInvokable compileModule(String moduleName, String code) throws Exception {
        final DynamicClassLoader classLoader = new DynamicClassLoader();

        Compiler.compileModule(code, new IOutputManager() {
            @Override
            public void append(String name, byte[] content) throws Exception {
                classLoader.addClass(name, content);
            }
        });

        Class moduleClass = classLoader.loadClass(moduleName);

        Constructor<? extends IInvokable> constructor = moduleClass.getConstructor();
        return constructor.newInstance();
    }

    public static Object compileAndInvoke(String moduleName, String code) throws Exception {
        IInvokable application = CompilerHelper.compileModule(moduleName, code);
        return application.invoke(new InvokeContext(null));
    }
}
