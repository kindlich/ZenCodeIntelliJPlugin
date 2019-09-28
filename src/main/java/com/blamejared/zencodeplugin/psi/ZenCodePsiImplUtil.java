package com.blamejared.zencodeplugin.psi;

import com.blamejared.zencodeplugin.reference.VariableNameReference;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("Duplicates")
public final class ZenCodePsiImplUtil {
    
    private ZenCodePsiImplUtil() {
    }
    //#################################
    //### ZenCodeVariable           ###
    //#################################
    
    @Contract("_, _ -> param1")
    public static PsiElement setName(@NotNull ZenCodeVariableName element, String newName) {
        final ASTNode name = element.getTIdentifier().getNode();
        final PsiElement identifier = ZenCodeElementFactory.createIdentifier(element.getProject(), newName);
        if(identifier != null) {
            element.getNode().replaceChild(name, identifier.getNode());
        }
        return element;
    }
    
    @NotNull
    @Contract("_ -> new")
    public static PsiReference getReference(ZenCodeVariableName element) {
        return new VariableNameReference(element, new TextRange(0, element.getTextLength()));
    }
    
    
    //#################################
    //### ZenCodeDeclareVariable    ###
    //#################################
    
    public static String getName(@NotNull ZenCodeDeclareVariableName element) {
        return element.getTIdentifier().getText();
    }
    
    @Contract("_, _ -> param1")
    public static PsiElement setName(@NotNull ZenCodeDeclareVariableName element, String newName) {
        final ASTNode name = element.getTIdentifier().getNode();
        final PsiElement identifier = ZenCodeElementFactory.createIdentifier(element.getProject(), newName);
        if(identifier != null) {
            element.getNode().replaceChild(name, identifier.getNode());
        }
        return element;
    }
    
    @Nullable
    public static PsiElement getNameIdentifier(ZenCodeDeclareVariableName element) {
        ASTNode keyNode = element.getNode().findChildByType(ZenCodeTypes.T_IDENTIFIER);
        if(keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }
}
