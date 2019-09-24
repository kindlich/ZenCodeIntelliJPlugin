package com.blamejared.zencodeplugin.psi;

import com.blamejared.zencodeplugin.language.ZenCodeLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

public class ZenCodeElementType extends IElementType {
    
    public ZenCodeElementType(@NotNull String debugName) {
        super(debugName, ZenCodeLanguage.INSTANCE);
    }
    
}
