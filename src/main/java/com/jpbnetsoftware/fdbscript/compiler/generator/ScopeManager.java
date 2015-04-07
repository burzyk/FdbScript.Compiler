package com.jpbnetsoftware.fdbscriptcompiler.generator;

/**
 * Created by pawel on 04/04/15.
 */
public class ScopeManager {

    private Scope currentScope;

    public Scope getCurrentScope() {
        return this.currentScope;
    }

    public void pushScope() {
        this.currentScope = new Scope(this.currentScope);
    }

    public void popScope() {
        this.currentScope = this.currentScope.getParent();
    }
}
