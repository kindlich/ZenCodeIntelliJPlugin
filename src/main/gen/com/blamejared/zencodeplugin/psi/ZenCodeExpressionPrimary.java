// This is a generated file. Not intended for manual editing.
package com.blamejared.zencodeplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ZenCodeExpressionPrimary extends PsiElement {

  @Nullable
  ZenCodeExpressionArray getExpressionArray();

  @Nullable
  ZenCodeExpressionBEP getExpressionBEP();

  @Nullable
  ZenCodeExpressionBracket getExpressionBracket();

  @Nullable
  ZenCodeExpressionMap getExpressionMap();

  @Nullable
  ZenCodeExpressionMatch getExpressionMatch();

  @Nullable
  ZenCodeExpressionNew getExpressionNew();

  @Nullable
  ZenCodeExpressionPanic getExpressionPanic();

  @Nullable
  ZenCodeExpressionThrow getExpressionThrow();

  @Nullable
  ZenCodeExpressionVariable getExpressionVariable();

  @Nullable
  ZenCodeType getType();

  @Nullable
  ZenCodeZCStringLiteral getZCStringLiteral();

  @Nullable
  PsiElement getTFloat();

  @Nullable
  PsiElement getTIdentifier();

  @Nullable
  PsiElement getTInt();

  @Nullable
  PsiElement getTLocalIdentifier();

  @Nullable
  PsiElement getTPrefixedInt();

}
