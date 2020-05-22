package com.blamejared.zencodeplugin.completion;

import com.blamejared.zencodeplugin.completion.types.*;
import com.blamejared.zencodeplugin.psi.*;
import com.intellij.lang.annotation.*;
import com.intellij.psi.*;
import com.intellij.psi.tree.*;
import org.jetbrains.annotations.*;

import static com.blamejared.zencodeplugin.completion.ZenCodeCompletionUtils.*;

public class ZenCodeAnnotator implements Annotator {
    
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        /*
        final IElementType elementType = element.getNode().getElementType();
        
        if(element.getCopyableUserData(TYPE_KEY) != null)
            return;
        
        if(elementType == ZenCodeTypes.EXPRESSION_BRACKET) {
            ZenCodeExpressionBEP bep = (ZenCodeExpressionBEP) element;
            final ZenCodeCompletionTypeInfo typeForBracket = ZenCodeCompletionUtils.getTypeForBracket(bep.getText());
            element.putCopyableUserData(TYPE_KEY, typeForBracket);
        } else if(element ==  ZenCodeTypes.EXPRESSION_POST_FIX) {
            final ZenCodeExpressionPostFix postFix = (ZenCodeExpressionPostFix) element;
        }
        
         */
    
}
}
