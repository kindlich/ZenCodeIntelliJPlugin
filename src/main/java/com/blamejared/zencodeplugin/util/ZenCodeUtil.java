package com.blamejared.zencodeplugin.util;

import com.blamejared.zencodeplugin.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class ZenCodeUtil {
    
    private ZenCodeUtil() {
    }
    
    public static Collection<ZenCodeDeclareVariableName> getAllVariableDeclarations(PsiElement before) {
        return getElementsDeclaredBefore(before, ZenCodeTypes.DECLARE_VARIABLE_NAME, ZenCodeTypes.STATEMENT_VAR)
                .stream()
                .map(e -> e instanceof ZenCodeStatementVar ? ((ZenCodeStatementVar) e).getDeclareVariableName() : (ZenCodeDeclareVariableName) e)
                .collect(Collectors.toList());
    }
    
    public static Collection<PsiElement> getElementsDeclaredBefore(PsiElement element, IElementType... types) {
        final ArrayList<PsiElement> results = new ArrayList<>();
        getElementsDeclaredBeforeRec(element, results, types);
        return results;
    }
    
    private static void getElementsDeclaredBeforeRec(PsiElement element, Collection<PsiElement> result, IElementType... types) {
        if(element == null)
            return;
    
        final ASTNode node = element.getNode();
        if(node == null)
            return;
        if(Arrays.asList(types).contains(node.getElementType())) {
            result.add(element);
        }
        getElementsDeclaredBeforeRec(element.getPrevSibling(), result, types);
        getElementsDeclaredBeforeRec(element.getParent(), result, types);
    }
}
