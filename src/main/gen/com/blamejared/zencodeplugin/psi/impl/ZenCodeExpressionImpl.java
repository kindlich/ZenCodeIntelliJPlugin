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

public class ZenCodeExpressionImpl extends ASTWrapperPsiElement implements ZenCodeExpression {

  public ZenCodeExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ZenCodeVisitor visitor) {
    visitor.visitExpression(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ZenCodeVisitor) accept((ZenCodeVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ZenCodeExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZenCodeExpression.class);
  }

  @Override
  @NotNull
  public List<ZenCodeExpressionBEP> getExpressionBEPList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZenCodeExpressionBEP.class);
  }

  @Override
  @NotNull
  public List<ZenCodeStatementBlock> getStatementBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZenCodeStatementBlock.class);
  }

  @Override
  @NotNull
  public List<ZenCodeType> getTypeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZenCodeType.class);
  }

  @Override
  @NotNull
  public List<ZenCodeZCStringLiteral> getZCStringLiteralList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZenCodeZCStringLiteral.class);
  }

}