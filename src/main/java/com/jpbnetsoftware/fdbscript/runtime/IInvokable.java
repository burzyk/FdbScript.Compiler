package com.jpbnetsoftware.fdbscript.runtime;

import java.util.Objects;

/**
 * Created by pawel on 07/04/15.
 */
public interface IInvokable {
    Objects invoke(InvokeContext context);
}
