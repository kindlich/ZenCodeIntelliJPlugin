package com.blamejared.zencodeplugin.completion.types;

import java.util.*;

public class ZenCodeCompletionTypeRegistry {
    private final Map<String, ZenCodeCompletionTypeInfo> knownTypes = new HashMap<>();
    
    
    public ZenCodeCompletionTypeInfo getType(String qualifiedName) {
        return knownTypes.computeIfAbsent(qualifiedName, ZenCodeCompletionTypeInfo::new);
    }
}
