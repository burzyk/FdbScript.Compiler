package com.jpbnetsoftware.fdbscript.runtime.interfaces.compare;

import com.jpbnetsoftware.fdbscript.runtime.objects.RuntimeBoolean;
import com.jpbnetsoftware.fdbscript.runtime.objects.RuntimeObject;

/**
 * Created by pawel on 15/04/15.
 */
public interface IRelation {

    RuntimeBoolean isGreaterEqual(RuntimeObject other);

    RuntimeBoolean isGreaterThen(RuntimeObject other);

    RuntimeBoolean isLessThan(RuntimeObject other);

    RuntimeBoolean isLessEqual(RuntimeObject other);
}
