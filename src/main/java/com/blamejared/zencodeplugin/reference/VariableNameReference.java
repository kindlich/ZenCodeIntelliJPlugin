package com.blamejared.zencodeplugin.reference;

import com.blamejared.zencodeplugin.language.Icons;
import com.blamejared.zencodeplugin.psi.ZenCodeDeclareVariableName;
import com.blamejared.zencodeplugin.psi.ZenCodeTypes;
import com.blamejared.zencodeplugin.psi.ZenCodeVariableName;
import com.blamejared.zencodeplugin.util.ZenCodeUtil;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class VariableNameReference extends PsiReferenceBase<PsiElement> {
    
    private final String key;
    
    public VariableNameReference(@NotNull PsiElement element, TextRange rangeInElement) {
        super(element, rangeInElement);
        this.key = element.getText().substring(rangeInElement.getStartOffset(), rangeInElement.getEndOffset());
    }
    
    @Nullable
    @Override
    public PsiElement resolve() {
        return ZenCodeUtil.getAllVariableDeclarations(myElement)
                .stream()
                .filter(va -> Objects.equals(va.getTIdentifier().getText(), key))
                .findFirst()
                .orElse(null);
    }
    
    @NotNull
    @Override
    public Object[] getVariants() {
        return ZenCodeUtil.getAllVariableDeclarations(myElement)
                .stream()
                .map(va -> LookupElementBuilder.create(va).withIcon(Icons.ZENCODE_ICON))
                .toArray();
        
        
    }
    
    @Override
    public PsiElement handleElementRename(@NotNull String newElementName) throws IncorrectOperationException {
        return ((ZenCodeVariableName) myElement).setName(newElementName);
    }
    
    @Override
    public boolean isReferenceTo(@NotNull PsiElement element) {
        return element instanceof ZenCodeDeclareVariableName && Objects.equals(((ZenCodeDeclareVariableName) element).getName(), key) && super.isReferenceTo(element);
    }
}
