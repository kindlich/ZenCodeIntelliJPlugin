package com.blamejared.zencodeplugin.completion;

import com.blamejared.zencodeplugin.language.Icons;
import com.blamejared.zencodeplugin.psi.*;
import com.blamejared.zencodeplugin.util.*;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.*;
import com.intellij.psi.*;
import com.intellij.util.*;
import org.jetbrains.annotations.*;

public class VariableNamesCompletionProvider extends CompletionProvider<CompletionParameters> {
    
    @Override
    protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet result) {
        final PsiElement prevSibling = parameters.getPosition().getPrevSibling();
        if(prevSibling == null) {
            return;
        }
        
        for(ZenCodeDeclareVariableName allVariableDeclaration : ZenCodeUtil.getAllVariableDeclarations(prevSibling)) {
            result.addElement(LookupElementBuilder.create(allVariableDeclaration).withIcon(Icons.ZENCODE_ICON));
        }
        
    }
}
