package com.blamejared.zencodeplugin.reference;

import com.blamejared.zencodeplugin.language.Icons;
import com.blamejared.zencodeplugin.psi.*;
import com.blamejared.zencodeplugin.util.*;
import com.intellij.codeInsight.lookup.*;
import com.intellij.openapi.util.*;
import com.intellij.psi.*;
import com.intellij.util.*;
import org.jetbrains.annotations.*;

import java.util.*;

public class VariableNameReference extends PsiReferenceBase<PsiElement> {
    
    private final String key;
    
    public VariableNameReference(@NotNull PsiElement element, TextRange rangeInElement) {
        super(element, rangeInElement);
        this.key = element.getText()
                .substring(rangeInElement.getStartOffset(), rangeInElement.getEndOffset());
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
        return ((ZenCodeNamedElement) myElement).setName(newElementName);
    }
    
    @Override
    public boolean isReferenceTo(@NotNull PsiElement element) {
        return element instanceof ZenCodeStatementVar && Objects.equals(((ZenCodeNamedElement) element)
                .getName(), key) && super.isReferenceTo(element);
    }
}
