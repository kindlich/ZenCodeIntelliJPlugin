package com.blamejared.zencodeplugin.reference;

import com.blamejared.zencodeplugin.flex.*;
import com.blamejared.zencodeplugin.psi.*;
import com.intellij.lang.*;
import com.intellij.lang.cacheBuilder.*;
import com.intellij.lang.findUsages.*;
import com.intellij.psi.*;
import com.intellij.psi.tree.*;
import org.jetbrains.annotations.*;

public class VariableNameFindUsagesProvider implements FindUsagesProvider {
    
    @Nullable
    @Override
    public WordsScanner getWordsScanner() {
        return new DefaultWordsScanner(new ZenCodeFlexAdapter(), TokenSet.create(ZenCodeTypes.T_IDENTIFIER), ZenCodeFlexParserDefinition.COMMENTS, ZenCodeFlexParserDefinition.STRING_LITERALS);
    }
    
    @Override
    public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
        return psiElement instanceof ZenCodeStatementVar || psiElement instanceof ZenCodeExpressionVariable;
    }
    
    @Nullable
    @Override
    public String getHelpId(@NotNull PsiElement psiElement) {
        return HelpID.FIND_OTHER_USAGES;
    }
    
    @NotNull
    @Override
    public String getType(@NotNull PsiElement element) {
        return "";
    }
    
    @NotNull
    @Override
    public String getDescriptiveName(@NotNull PsiElement element) {
        if(element instanceof PsiNamedElement) {
            final String name = ((PsiNamedElement) element).getName();
            if(name != null) {
                return name;
            }
        }
        
        return "";
    }
    
    @NotNull
    @Override
    public String getNodeText(@NotNull PsiElement element, boolean useFullName) {
        return getDescriptiveName(element);
    }
}
