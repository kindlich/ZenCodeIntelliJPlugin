package com.blamejared.zencodeplugin.flex;

import com.blamejared.zencodeplugin.language.ZenCodeFile;
import com.blamejared.zencodeplugin.language.ZenCodeLanguage;
import com.blamejared.zencodeplugin.parser.ZenCodeParser;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

import static com.blamejared.zencodeplugin.psi.ZenCodeTypes.*;


public class ZenCodeFlexParserDefinition implements ParserDefinition {
    
    public static final IFileElementType FILE = new IFileElementType(ZenCodeLanguage.INSTANCE);
    
    public static final TokenSet WHITE_SPACES = TokenSet.create(T_WHITESPACE_CARRIAGE_RETURN, T_WHITESPACE_NEWLINE, T_WHITESPACE_SPACE, T_WHITESPACE_TAB, TokenType.WHITE_SPACE);
    public static final TokenSet COMMENTS = TokenSet.create(T_COMMENT_SCRIPT, T_COMMENT_SINGLELINE, T_COMMENT_MULTILINE);
    public static final TokenSet STRING_LITERALS = TokenSet.create(ZC_STRING_LITERAL, T_STRING_DQ_WYSIWYG, T_STRING_SQ_WYSIWYG);
    
    
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
        return Factory.createElement(node);
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
