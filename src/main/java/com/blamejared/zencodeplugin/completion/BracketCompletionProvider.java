package com.blamejared.zencodeplugin.completion;

import com.blamejared.zencodeplugin.components.ZenCodeProjectComponent;
import com.blamejared.zencodeplugin.psi.ZenCodeTypes;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.*;

public class BracketCompletionProvider extends CompletionProvider<CompletionParameters> {
    
    private static Map<String, Collection<String>> bracketExpressions = null;
    
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
    
    public static void readBrackets(boolean forced) {
        if(!forced && bracketExpressions != null)
            return;
        
        final File dumpFolder = new File(ZenCodeProjectComponent.getInstance().getBracketFolderLocation());
        
        
        if(dumpFolder.exists() && dumpFolder.isDirectory()) {
            final File[] files = dumpFolder.listFiles();
            if(files == null)
                return;
            
            bracketExpressions = new HashMap<>();
            
            for(File file : files) {
                final String name = file.getName();
                bracketExpressions.merge(name, new ArrayList<>(), (strings, strings2) -> {
                    strings.addAll(strings2);
                    return strings;
                });
                try(final BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    reader.lines().forEach(s -> bracketExpressions.get(name).add(s));
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    @Override
    protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet result) {
        
        final PsiElement position = parameters.getPosition();
        readBrackets(false);
        
        final String prefix = buildBEP(position.getPrevSibling());
        if(bracketExpressions == null)
            return;
        
        for(Map.Entry<String, Collection<String>> stringCollectionEntry : bracketExpressions.entrySet()) {
            final String fileName = stringCollectionEntry.getKey();
            stringCollectionEntry.getValue()
                    .stream()
                    .filter(s -> s.startsWith(prefix))
                    .map(lookupString -> LookupElementBuilder.create(lookupString.substring(prefix.length()))
                            .withCaseSensitivity(false)
                            .withTypeText(fileName))
                    .forEach(result::addElement);
        }
    }
}