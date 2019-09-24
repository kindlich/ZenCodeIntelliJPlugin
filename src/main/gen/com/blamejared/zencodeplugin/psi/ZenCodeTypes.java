// This is a generated file. Not intended for manual editing.
package com.blamejared.zencodeplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.blamejared.zencodeplugin.psi.impl.*;

public interface ZenCodeTypes {

  IElementType PROPERTY = new ZenCodeElementType("PROPERTY");

  IElementType CLRF = new ZenCodeTokenType("CLRF");
  IElementType COMMENT = new ZenCodeTokenType("COMMENT");
  IElementType KEY = new ZenCodeTokenType("KEY");
  IElementType SEPARATOR = new ZenCodeTokenType("SEPARATOR");
  IElementType VALUE = new ZenCodeTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROPERTY) {
        return new ZenCodePropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
