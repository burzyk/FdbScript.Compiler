package com.jpbnetsoftware.fdbscriptcompiler.generator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pawel on 04/04/15.
 */
public class Scope {

    private Scope parent;

    private Map<String, ICodeBlock> definitions = new HashMap<String, ICodeBlock>();

    public Scope(Scope parent) {
        this.parent = parent;
    }

    public ICodeBlock findDefinition(String name) {
        ICodeBlock block = this.definitions.getOrDefault(name, null);
        return block != null ? block : this.parent != null ? this.parent.findDefinition(name) : null;
    }

    public void addDefinition(String name, ICodeBlock definition) {
        this.definitions.put(name, definition);
    }

    public Scope getParent() {
        return this.parent;
    }
}
