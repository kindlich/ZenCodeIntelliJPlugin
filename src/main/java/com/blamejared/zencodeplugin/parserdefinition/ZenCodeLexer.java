package com.blamejared.zencodeplugin.parserdefinition;

import com.intellij.lexer.Lexer;
import com.intellij.lexer.LexerPosition;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ZenCodeLexer extends Lexer {
    
    @Override
    public void start(@NotNull CharSequence buffer, int startOffset, int endOffset, int initialState) {
    
    }
    
    @Override
    public int getState() {
        return 0;
    }
    
    @Nullable
    @Override
    public IElementType getTokenType() {
        return null;
    }
    
    @Override
    public int getTokenStart() {
        return 0;
    }
    
    @Override
    public int getTokenEnd() {
        return 0;
    }
    
    @Override
    public void advance() {
    
    }
    
    @NotNull
    @Override
    public LexerPosition getCurrentPosition() {
        return null;
    }
    
    @Override
    public void restore(@NotNull LexerPosition position) {
    
    }
    
    @NotNull
    @Override
    public CharSequence getBufferSequence() {
        return null;
    }
    
    @Override
    public int getBufferEnd() {
        return 0;
    }
}
