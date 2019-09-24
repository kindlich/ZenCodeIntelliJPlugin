package com.blamejared.zencodeplugin.language;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class ZenCodeFileType extends LanguageFileType {
    public static final ZenCodeFileType INSTANCE = new ZenCodeFileType();
    
    private ZenCodeFileType() {
        super(ZenCodeLanguage.INSTANCE);
    }
    
    @NotNull
    @Override
    public String getName() {
        return "ZenCode file";
    }
    
    @NotNull
    @Override
    public String getDescription() {
        return "ZenCode source file";
    }
    
    @NotNull
    @Override
    public String getDefaultExtension() {
        return "zc";
    }
    
    @Nullable
    @Override
    public Icon getIcon() {
        return Icons.ZENCODE_ICON;
    }
}
