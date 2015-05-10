package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IEmitter;
import com.jpbnetsoftware.fdbscript.runtime.RuntimeMethods;
import org.apache.bcel.Constants;
import org.apache.bcel.generic.*;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pawel on 05/05/15.
 */
public class RuntimeCallCodeBlock extends JvmCodeBlock {

    private ICodeBlock[] expressions;

    private String methodName;

    public RuntimeCallCodeBlock(String methodName, ICodeBlock... expressions) {
        this.expressions = expressions;
        this.methodName = methodName;
    }

    @Override
    protected void emitInternal(IEmitter emitter, InstructionList il, InstructionFactory factory) {

        Method[] methods = RuntimeMethods.class.getMethods();
        Method method = null;

        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getName().equals(this.methodName)) {
                method = methods[i];
            }
        }

        if (method == null) {
            // TODO: error handling
        }

        Parameter[] parameters = method.getParameters();

        for (int i = 0; i < parameters.length; i++) {
            this.expressions[i].emit(emitter);
            Class parameterClass = parameters[i].getType();

            if (parameterClass != Object.class) {
                il.append(factory.createCheckCast(this.convertJavaType(parameterClass)));
            }
        }

        il.append(factory.createInvoke(
                "com.jpbnetsoftware.fdbscript.runtime.RuntimeMethods",
                this.methodName,
                this.convertJavaType(method.getReturnType()),
                this.getTypesArray(parameters),
                Constants.INVOKESTATIC));
    }

    private Type[] getTypesArray(Parameter[] params) {
        Type[] types = new Type[params.length];

        for (int i = 0; i < params.length; i++) {
            types[i] = this.convertJavaType(params[i].getType());
        }

        return types;
    }

    private ReferenceType convertJavaType(Class clazz) {
        return clazz.isArray() ? new ArrayType(Type.OBJECT, 1) : new ObjectType(clazz.getTypeName());
    }
}
