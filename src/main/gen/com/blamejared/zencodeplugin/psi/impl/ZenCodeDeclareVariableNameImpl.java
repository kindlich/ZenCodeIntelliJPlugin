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

public class ZenCodeDeclareVariableNameImpl extends ASTWrapperPsiElement implements ZenCodeDeclareVariableName {

  public ZenCodeDeclareVariableNameImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ZenCodeVisitor visitor) {
    visitor.visitDeclareVariableName(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ZenCodeVisitor) accept((ZenCodeVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getTIdentifier() {
    return findNotNullChildByType(T_IDENTIFIER);
  }

  @Override
  public String getName() {
    return ZenCodePsiImplUtil.getName(this);
  }

  @Override
  public PsiElement setName(String newName) {
    return ZenCodePsiImplUtil.setName(this, newName);
  }

  @Override
  @Nullable
  public PsiElement getNameIdentifier() {
    return ZenCodePsiImplUtil.getNameIdentifier(this);
  }

}
