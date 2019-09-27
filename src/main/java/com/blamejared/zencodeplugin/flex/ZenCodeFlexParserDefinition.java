package com.blamejared.zencodeplugin.flex;

import com.blamejared.zencodeplugin.language.ZenCodeFile;
import com.blamejared.zencodeplugin.language.ZenCodeLanguage;
import com.blamejared.zencodeplugin.parser.ZenCodeParser;
import com.blamejared.zencodeplugin.psi.ZenCodeTypes;
import com.blamejared.zencodeplugin.psi.ZenCodeTypes;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;


public class ZenCodeFlexParserDefinition implements ParserDefinition {
    
    public static final TokenSet WHITE_SPACES = TokenSet.create(ZenCodeTypes.K_WHILE);
    public static final TokenSet COMMENTS = TokenSet.create();//TODO comments
    public static final TokenSet STRING_LITERALS = TokenSet.create(ZenCodeTypes.T_STRING_DQ, ZenCodeTypes.T_STRING_SQ);
    
    public static final IFileElementType FILE = new IFileElementType(ZenCodeLanguage.INSTANCE);
    
    
    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new ZenCodeFlexAdapter();
    }
    
    @Override
    public PsiParser createParser(Project project) {
        return new ZenCodeParser();
    }
    
    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }
    
    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }
    
    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return STRING_LITERALS;
    }
    
    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
       return ZenCodeTypes.Factory.createElement(node);
    }
    
    @Override
    public PsiFile createFile(FileViewProvider viewProvider) {
        return new ZenCodeFile(viewProvider);
    }
    
    @NotNull
    @Override
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }
}
