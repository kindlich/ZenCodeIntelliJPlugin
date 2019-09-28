package com.blamejared.zencodeplugin.reference;

import com.blamejared.zencodeplugin.psi.ZenCodeDeclareVariableName;
import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class VariableNameRefactoringSupportProvider extends RefactoringSupportProvider {
    
    @Override
    public boolean isMemberInplaceRenameAvailable(@NotNull PsiElement element, @Nullable PsiElement context) {
        return element instanceof ZenCodeDeclareVariableName;
    }
}
