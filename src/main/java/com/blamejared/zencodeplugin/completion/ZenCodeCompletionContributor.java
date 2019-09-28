package com.blamejared.zencodeplugin.completion;

import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionType;

import static com.blamejared.zencodeplugin.psi.ZenCodeTypes.*;
import static com.intellij.patterns.PlatformPatterns.psiElement;
import static com.intellij.patterns.StandardPatterns.or;


public class ZenCodeCompletionContributor extends CompletionContributor {
    
    public ZenCodeCompletionContributor() {
        extend(CompletionType.BASIC, psiElement(T_IDENTIFIER).afterSiblingSkipping(or(psiElement().whitespace(), psiElement(T_COLON), psiElement(T_IDENTIFIER), psiElement(T_INT)), psiElement(T_LESS)), new BracketCompletionProvider());
    }
}
