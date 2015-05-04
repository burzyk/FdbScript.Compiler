package com.jpbnetsoftware.fdbscript.runtime.objects;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by pawel on 04/05/15.
 */
public class RuntimeObject {

    private Map<String, Object> map = new HashMap<String, Object>();

    public void defineValue(String name, Object value) {
        this.map.put(name, value);
    }

    public Object getValue(String name) {
        return this.map.get(name);
    }

    @Override
    public boolean equals(Object second) {

        if (!(second instanceof RuntimeObject)) {
            return false;
        }

        Map<String, Object> secondMap = ((RuntimeObject) second).map;

        if (secondMap.size() != this.map.size()) {
            return false;
        }

        for (String key : this.map.keySet()) {

            if (!secondMap.containsKey(key)) {
                return false;
            }

            Object thisValue = this.map.get(key);
            Object secondValue = secondMap.get(key);

            if (!thisValue.equals(secondValue)) {
                return false;
            }
        }

        return true;
    }
}
