package com.blamejared.zencodeplugin.flex;

import com.intellij.lexer.FlexAdapter;

public class ZenCodeFlexAdapter extends FlexAdapter {
    
    public ZenCodeFlexAdapter() {
        super(new _ZenCodeLexer(null));
    }
}
