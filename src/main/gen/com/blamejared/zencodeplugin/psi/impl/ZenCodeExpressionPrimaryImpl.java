// This is a generated file. Not intended for manual editing.
package com.blamejared.zencodeplugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.blamejared.zencodeplugin.psi.ZenCodeTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.blamejared.zencodeplugin.psi.*;

public class ZenCodeExpressionPrimaryImpl extends ASTWrapperPsiElement implements ZenCodeExpressionPrimary {

  public ZenCodeExpressionPrimaryImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ZenCodeVisitor visitor) {
    visitor.visitExpressionPrimary(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ZenCodeVisitor) accept((ZenCodeVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ZenCodeExpressionArray getExpressionArray() {
    return findChildByClass(ZenCodeExpressionArray.class);
  }

  @Override
  @Nullable
  public ZenCodeExpressionBEP getExpressionBEP() {
    return findChildByClass(ZenCodeExpressionBEP.class);
  }

  @Override
  @Nullable
  public ZenCodeExpressionBracket getExpressionBracket() {
    return findChildByClass(ZenCodeExpressionBracket.class);
  }

  @Override
  @Nullable
  public ZenCodeExpressionMap getExpressionMap() {
    return findChildByClass(ZenCodeExpressionMap.class);
  }

  @Override
  @Nullable
  public ZenCodeExpressionMatch getExpressionMatch() {
    return findChildByClass(ZenCodeExpressionMatch.class);
  }

  @Override
  @Nullable
  public ZenCodeExpressionNew getExpressionNew() {
    return findChildByClass(ZenCodeExpressionNew.class);
  }

  @Override
  @Nullable
  public ZenCodeExpressionPanic getExpressionPanic() {
    return findChildByClass(ZenCodeExpressionPanic.class);
  }

  @Override
  @Nullable
  public ZenCodeExpressionThrow getExpressionThrow() {
    return findChildByClass(ZenCodeExpressionThrow.class);
  }

  @Override
  @Nullable
  public ZenCodeExpressionVariable getExpressionVariable() {
    return findChildByClass(ZenCodeExpressionVariable.class);
  }

  @Override
  @Nullable
  public ZenCodeType getType() {
    return findChildByClass(ZenCodeType.class);
  }

  @Override
  @Nullable
  public ZenCodeZCStringLiteral getZCStringLiteral() {
    return findChildByClass(ZenCodeZCStringLiteral.class);
  }

  @Override
  @Nullable
  public PsiElement getTFloat() {
    return findChildByType(T_FLOAT);
  }

  @Override
  @Nullable
  public PsiElement getTIdentifier() {
    return findChildByType(T_IDENTIFIER);
  }

  @Override
  @Nullable
  public PsiElement getTInt() {
    return findChildByType(T_INT);
  }

  @Override
  @Nullable
  public PsiElement getTLocalIdentifier() {
    return findChildByType(T_LOCAL_IDENTIFIER);
  }

  @Override
  @Nullable
  public PsiElement getTPrefixedInt() {
    return findChildByType(T_PREFIXED_INT);
  }

}
