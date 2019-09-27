package com.blamejared.zencodeplugin.language;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class ZenCodeFile extends PsiFileBase {
    
    public ZenCodeFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, ZenCodeLanguage.INSTANCE);
    }
    
    @NotNull
    @Override
    public FileType getFileType() {
        return ZenCodeFileType.INSTANCE;
    }
}
