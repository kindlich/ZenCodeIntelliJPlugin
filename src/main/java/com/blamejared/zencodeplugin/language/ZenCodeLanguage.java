package com.blamejared.zencodeplugin.language;

import com.intellij.lang.Language;

public class ZenCodeLanguage extends Language {
    
    public static final ZenCodeLanguage INSTANCE = new ZenCodeLanguage();
    
    private ZenCodeLanguage() {
        super("ZenCode", ".zc", ".zs");
    }
}
