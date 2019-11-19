package com.blamejared.zencodeplugin.completion.types;

import java.util.*;

public class ZenCodeCompletionTypeInfo {
    
    private final String fullName;
    private final Map<String, Collection<ZenCodeCompletionTypeMethodInfo>> methods;
    
    public ZenCodeCompletionTypeInfo(String fullName) {
        this.fullName = fullName;
        this.methods = new HashMap<>();
    }
    
    public String getFullName() {
        return fullName;
    }
    
    public Map<String, Collection<ZenCodeCompletionTypeMethodInfo>> getMethods() {
        return methods;
    }
    
    
    @Override
    public String toString() {
        return "Type Info: " + fullName;
    }
}
