package com.jpbnetsoftware.fdbscript.compiler.generator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pawel on 04/04/15.
 */
public class Scope {

    private Scope parent;

    private Map<String, IDefinitionCodeBlock> definitions = new HashMap<String, IDefinitionCodeBlock>();

    public Scope(Scope parent) {
        this.parent = parent;
    }

    public IDefinitionCodeBlock findDefinition(String name) {
        IDefinitionCodeBlock block = this.definitions.getOrDefault(name, null);
        return block != null ? block : this.parent != null ? this.parent.findDefinition(name) : null;
    }

    public void addDefinition(String name, IDefinitionCodeBlock definition) {
        this.definitions.put(name, definition);
    }

    public Scope getParent() {
        return this.parent;
    }
}
