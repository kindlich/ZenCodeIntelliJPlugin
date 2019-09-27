package com.blamejared.zencodeplugin.highlighter;

import com.blamejared.zencodeplugin.flex.ZenCodeFlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

import static com.blamejared.zencodeplugin.psi.ZenCodeTypes.*;
import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class ZenCodeSyntaxHighlighter extends SyntaxHighlighterBase {
    
    public static final TextAttributesKey STRING_LITERAL = createTextAttributesKey("STRING_LITERAL", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey ZC_HIGHLIGHT_IDENTIFIER = createTextAttributesKey("ZC_HIGHLIGHT_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey ZC_HIGHLIGHT_NUMBER = createTextAttributesKey("ZC_HIGHLIGHT_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey ZC_HIGHLIGHT_BLOCK_COMMENT = createTextAttributesKey("ZC_HIGHLIGHT_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT);
    public static final TextAttributesKey ZC_HIGHLIGHT_LINE_COMMENT = createTextAttributesKey("ZC_HIGHLIGHT_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey ZC_HIGHLIGHT_SCRIPT_COMMENT = createTextAttributesKey("ZC_HIGHLIGHT_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey ZC_HIGHLIGHT_OPERATION_SIGN = createTextAttributesKey("ZC_HIGHLIGHT_OPERATION_SIGN", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey ZC_HIGHLIGHT_BRACES = createTextAttributesKey("ZC_HIGHLIGHT_BRACES", DefaultLanguageHighlighterColors.BRACES);
    public static final TextAttributesKey ZC_HIGHLIGHT_DOT = createTextAttributesKey("ZC_HIGHLIGHT_DOT", DefaultLanguageHighlighterColors.DOT);
    public static final TextAttributesKey ZC_HIGHLIGHT_SEMICOLON = createTextAttributesKey("ZC_HIGHLIGHT_SEMICOLON", DefaultLanguageHighlighterColors.SEMICOLON);
    public static final TextAttributesKey ZC_HIGHLIGHT_COMMA = createTextAttributesKey("ZC_HIGHLIGHT_COMMA", DefaultLanguageHighlighterColors.COMMA);
    public static final TextAttributesKey ZC_HIGHLIGHT_PARENTHESES = createTextAttributesKey("ZC_HIGHLIGHT_PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES);
    public static final TextAttributesKey ZC_HIGHLIGHT_BRACKETS = createTextAttributesKey("ZC_HIGHLIGHT_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS);
    public static final TextAttributesKey ZC_HIGHLIGHT_KEYWORD = createTextAttributesKey("ZC_HIGHLIGHT_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    
    
    private static final TextAttributesKey[] ZC_HIGHLIGHT_STRING_ARRAY = new TextAttributesKey[]{STRING_LITERAL};
    private static final TextAttributesKey[] ZC_HIGHLIGHT_IDENTIFIER_ARRAY = new TextAttributesKey[]{ZC_HIGHLIGHT_IDENTIFIER};
    private static final TextAttributesKey[] ZC_HIGHLIGHT_NUMBER_ARRAY = new TextAttributesKey[]{ZC_HIGHLIGHT_NUMBER};
    private static final TextAttributesKey[] ZC_HIGHLIGHT_BLOCK_COMMENT_ARRAY = new TextAttributesKey[]{ZC_HIGHLIGHT_BLOCK_COMMENT};
    private static final TextAttributesKey[] ZC_HIGHLIGHT_LINE_COMMENT_ARRAY = new TextAttributesKey[]{ZC_HIGHLIGHT_LINE_COMMENT};
    private static final TextAttributesKey[] ZC_HIGHLIGHT_SCRIPT_COMMENT_ARRAY = new TextAttributesKey[]{ZC_HIGHLIGHT_SCRIPT_COMMENT};
    private static final TextAttributesKey[] ZC_HIGHLIGHT_OPERATION_SIGN_ARRAY = new TextAttributesKey[]{ZC_HIGHLIGHT_OPERATION_SIGN};
    private static final TextAttributesKey[] ZC_HIGHLIGHT_BRACES_ARRAY = new TextAttributesKey[]{ZC_HIGHLIGHT_BRACES};
    private static final TextAttributesKey[] ZC_HIGHLIGHT_DOT_ARRAY = new TextAttributesKey[]{ZC_HIGHLIGHT_DOT};
    private static final TextAttributesKey[] ZC_HIGHLIGHT_SEMICOLON_ARRAY = new TextAttributesKey[]{ZC_HIGHLIGHT_SEMICOLON};
    private static final TextAttributesKey[] ZC_HIGHLIGHT_COMMA_ARRAY = new TextAttributesKey[]{ZC_HIGHLIGHT_COMMA};
    private static final TextAttributesKey[] ZC_HIGHLIGHT_PARENTHESES_ARRAY = new TextAttributesKey[]{ZC_HIGHLIGHT_PARENTHESES};
    private static final TextAttributesKey[] ZC_HIGHLIGHT_BRACKETS_ARRAY = new TextAttributesKey[]{ZC_HIGHLIGHT_BRACKETS};
    private static final TextAttributesKey[] ZC_HIGHLIGHT_KEYWORD_ARRAY = new TextAttributesKey[]{ZC_HIGHLIGHT_KEYWORD};
    private static final TextAttributesKey[] EMPTY = new TextAttributesKey[0];
    
    
    private static <T> boolean equalsAny(T item, T... toCheck) {
        return Arrays.asList(toCheck).contains(item);
    }
    
    
    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new ZenCodeFlexAdapter();
    }
    
    @SuppressWarnings("Duplicates")//Why yes ofc, this method has statements that look alike, duh
    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if(equalsAny(tokenType, T_STRING_SQ, T_STRING_DQ, T_STRING_DQ_WYSIWYG, T_STRING_SQ_WYSIWYG))
            return ZC_HIGHLIGHT_STRING_ARRAY;
        if(equalsAny(tokenType, T_IDENTIFIER, T_LOCAL_IDENTIFIER))
            return ZC_HIGHLIGHT_IDENTIFIER_ARRAY;
        if(equalsAny(tokenType, T_INT, T_PREFIXED_INT, T_FLOAT))
            return ZC_HIGHLIGHT_NUMBER_ARRAY;
        if(equalsAny(tokenType, T_COMMENT_MULTILINE))
            return ZC_HIGHLIGHT_BLOCK_COMMENT_ARRAY;
        if(equalsAny(tokenType, T_COMMENT_SINGLELINE))
            return ZC_HIGHLIGHT_LINE_COMMENT_ARRAY;
        if(equalsAny(tokenType, T_COMMENT_SCRIPT))
            return ZC_HIGHLIGHT_SCRIPT_COMMENT_ARRAY;
        //Operators missing
        if(equalsAny(tokenType, T_AOPEN, T_ACLOSE))
            return ZC_HIGHLIGHT_BRACES_ARRAY;
        if(equalsAny(tokenType, T_DOT, T_DOT2, T_DOT3))
            return ZC_HIGHLIGHT_DOT_ARRAY;
        if(equalsAny(tokenType, T_SEMICOLON))
            return ZC_HIGHLIGHT_SEMICOLON_ARRAY;
        if(equalsAny(tokenType, T_COMMA))
            return ZC_HIGHLIGHT_COMMA_ARRAY;
        if(equalsAny(tokenType, T_BROPEN, T_BRCLOSE))
            return ZC_HIGHLIGHT_PARENTHESES_ARRAY;
        if(equalsAny(tokenType, T_SQOPEN, T_SQCLOSE))
            return ZC_HIGHLIGHT_BRACKETS_ARRAY;
        if(equalsAny(tokenType, K_ABSTRACT, K_ALIAS, K_AS, K_BOOL, K_BREAK, K_BYTE, K_CASE, K_CATCH, K_CHAR, K_CLASS, K_CONST, K_CONTINUE, K_DEFAULT, K_DO, K_DOUBLE, K_ELSE, K_ENUM, K_EXPAND, K_EXPANSION, K_EXPORT, K_EXTERN, K_FALSE, K_FINAL, K_FINALLY, K_FLOAT, K_FOR, K_FUNCTION, K_GET, K_IF, K_IMMUTABLE, K_IMPLEMENTS, K_IMPLICIT, K_IMPORT, K_IN, K_INT, K_INTERFACE, K_INTERNAL, K_IS, K_LOCK, K_LONG, K_MATCH, K_NEW, K_NULL, K_OVERRIDE, K_PANIC, K_PRIVATE, K_PROTECTED, K_PUBLIC, K_RETURN, K_SBYTE, K_SET, K_SHORT, K_STATIC, K_STRING, K_STRUCT, K_SUPER, K_SWITCH, K_THIS, K_THROW, K_THROWS, K_TRUE, K_TRY, K_UINT, K_ULONG, K_USHORT, K_USIZE, K_VAL, K_VAR, K_VARIANT, K_VIRTUAL, K_VOID, K_WHILE))
            return ZC_HIGHLIGHT_KEYWORD_ARRAY;
        return EMPTY;
    }
}
