package com.blamejared.zencodeplugin.reference;

import com.blamejared.zencodeplugin.highlighter.ZenCodeSyntaxHighlighter;
import com.intellij.lang.refactoring.NamesValidator;
import com.intellij.openapi.project.Project;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public class VariableNameNamesValidator implements NamesValidator {
    
    private static final Predicate<String> identifierPredicate;
    
    static {
        final Predicate<String> identifier = Pattern.compile("@?[a-zA-Z_][a-zA-Z_0-9]*").asPredicate();
        final Predicate<String> localIdentifier = Pattern.compile("\\$[a-zA-Z_][a-zA-Z_0-9]*").asPredicate();
        identifierPredicate = identifier.or(localIdentifier);
    }
    
    @Override
    public boolean isKeyword(@NotNull String name, Project project) {
        for(IElementType keywordElement : ZenCodeSyntaxHighlighter.KEYWORD_ELEMENTS) {
            if(keywordElement.toString().equals(name))
                return true;
        }
        
        return false;
    }
    
    @Override
    public boolean isIdentifier(@NotNull String name, Project project) {
        return identifierPredicate.test(name);
    }
}
