package com.blamejared.zencodeplugin.reference;

import com.blamejared.zencodeplugin.flex.ZenCodeFlexAdapter;
import com.blamejared.zencodeplugin.flex.ZenCodeFlexParserDefinition;
import com.blamejared.zencodeplugin.psi.ZenCodeDeclareVariableName;
import com.blamejared.zencodeplugin.psi.ZenCodeTypes;
import com.intellij.lang.HelpID;
import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class VariableNameFindUsagesProvider implements FindUsagesProvider {
    
    @Nullable
    @Override
    public WordsScanner getWordsScanner() {
        return new DefaultWordsScanner(new ZenCodeFlexAdapter(), TokenSet.create(ZenCodeTypes.T_IDENTIFIER), ZenCodeFlexParserDefinition.COMMENTS, ZenCodeFlexParserDefinition.STRING_LITERALS);
    }
    
    @Override
    public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
        return psiElement instanceof ZenCodeDeclareVariableName;
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
