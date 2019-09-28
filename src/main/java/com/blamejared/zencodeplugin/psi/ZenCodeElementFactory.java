package com.blamejared.zencodeplugin.psi;

import com.blamejared.zencodeplugin.language.ZenCodeFile;
import com.blamejared.zencodeplugin.language.ZenCodeFileType;
import com.blamejared.zencodeplugin.language.ZenCodeFileTypeFactory;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.tree.IElementType;

public class ZenCodeElementFactory {
    public static PsiElement createIdentifier(Project project, String name) {
        final ASTNode childByType = createFile(project, name).getNode().findChildByType(ZenCodeTypes.T_IDENTIFIER);
        return childByType != null ? childByType.getPsi() : null;
    }
    
    
    public static ZenCodeFile createFile(Project project, String text) {
        return (ZenCodeFile) PsiFileFactory.getInstance(project).createFileFromText("dummy.zc", ZenCodeFileType.INSTANCE, text);
    }
}
