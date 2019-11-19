package com.blamejared.zencodeplugin.completion.types;

public class ZenCodeCompletionTypeMethodInfo {
    private final String name;
    private final ZenCodeCompletionTypeInfo[] argumentTypes;
    private final ZenCodeCompletionTypeInfo returnType;
    
    public ZenCodeCompletionTypeMethodInfo(String name, ZenCodeCompletionTypeInfo[] argumentTypes, ZenCodeCompletionTypeInfo returnType) {
        this.name = name;
        this.argumentTypes = argumentTypes;
        this.returnType = returnType;
    }
    
    public String getName() {
        return name;
    }
    
    public ZenCodeCompletionTypeInfo[] getArgumentTypes() {
        return argumentTypes;
    }
    
    public ZenCodeCompletionTypeInfo getReturnType() {
        return returnType;
    }
}
