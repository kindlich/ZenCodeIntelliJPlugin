package com.blamejared;

import org.openzen.zenscript.lexer.ZSTokenType;

public class ttt {
    
    public static void main(String[] args) {
        for(ZSTokenType value : ZSTokenType.values()) {
            System.out.printf("%s=%s%n", value.name(), value.isKeyword ? value.flyweight.content : value.getRegexp());
        }
    }
}
