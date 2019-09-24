package com.blamejared.zencodeplugin.psi;

import com.blamejared.zencodeplugin.language.ZenCodeLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

public class ZenCodeTokenType extends IElementType {
    
    public ZenCodeTokenType(@NotNull String debugName) {
        super(debugName, ZenCodeLanguage.INSTANCE);
    }
    
    @Override
    public String toString() {
        return "ZenCodeTokenType." + super.toString();
    }
}
