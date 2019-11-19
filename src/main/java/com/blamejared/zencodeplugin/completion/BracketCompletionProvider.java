package com.blamejared.zencodeplugin.completion;

import com.blamejared.zencodeplugin.psi.*;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.*;
import com.intellij.lang.*;
import com.intellij.psi.*;
import com.intellij.util.*;
import org.jetbrains.annotations.*;

import java.util.*;

public class BracketCompletionProvider extends CompletionProvider<CompletionParameters> {
    
    @NotNull
    private static String buildBEP(PsiElement currentElement) {
        final StringBuilder sb = new StringBuilder();
        buildBEPRec(currentElement, sb);
        return sb.toString();
    }
    
    private static void buildBEPRec(PsiElement currentElement, StringBuilder builder) {
        if(currentElement == null)
            return;
        
        final ASTNode node = currentElement.getNode();
        if(node == null) {
            return;
        }
        
        if(!node.getElementType().equals(ZenCodeTypes.T_LESS)) {
            buildBEPRec(currentElement.getPrevSibling(), builder);
        }
        builder.append(currentElement.getText());
    }
    
    @Override
    protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet result) {
        
        final PsiElement position = parameters.getPosition();
        ZenCodeCompletionUtils.readBrackets(false);
        
        final Map<String, Collection<String>> bracketExpressions = ZenCodeCompletionUtils.getBracketExpressions();
        final String prefix = buildBEP(position.getPrevSibling());
        if(bracketExpressions == null)
            return;
        
        for(Map.Entry<String, Collection<String>> stringCollectionEntry : bracketExpressions.entrySet()) {
            final String fileName = stringCollectionEntry.getKey();
            stringCollectionEntry.getValue().stream().filter(s -> s.startsWith(prefix)).map(lookupString -> LookupElementBuilder.create(lookupString.substring(prefix.length())).withCaseSensitivity(false).withTypeText(fileName)).forEach(result::addElement);
        }
    }
}