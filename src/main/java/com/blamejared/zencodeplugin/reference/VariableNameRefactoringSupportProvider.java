package com.blamejared.zencodeplugin.reference;

import com.blamejared.zencodeplugin.psi.*;
import com.intellij.lang.refactoring.*;
import com.intellij.psi.*;
import org.jetbrains.annotations.*;

public class VariableNameRefactoringSupportProvider extends RefactoringSupportProvider {
    
    @Override
    public boolean isMemberInplaceRenameAvailable(@NotNull PsiElement element, @Nullable PsiElement context) {
        return element instanceof ZenCodeStatementVar || element instanceof ZenCodeExpressionVariable;
    }
}
