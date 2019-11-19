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

public class ZenCodeExpressionPostFixImpl extends ASTWrapperPsiElement implements ZenCodeExpressionPostFix {

  public ZenCodeExpressionPostFixImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ZenCodeVisitor visitor) {
    visitor.visitExpressionPostFix(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ZenCodeVisitor) accept((ZenCodeVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ZenCodeCallArguments> getCallArgumentsList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZenCodeCallArguments.class);
  }

  @Override
  @NotNull
  public List<ZenCodeExpressionAssign> getExpressionAssignList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZenCodeExpressionAssign.class);
  }

  @Override
  @NotNull
  public ZenCodeExpressionPrimary getExpressionPrimary() {
    return findNotNullChildByClass(ZenCodeExpressionPrimary.class);
  }

  @Override
  @NotNull
  public List<ZenCodeLambdaBody> getLambdaBodyList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZenCodeLambdaBody.class);
  }

  @Override
  @NotNull
  public List<ZenCodeType> getTypeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZenCodeType.class);
  }

  @Override
  @NotNull
  public List<ZenCodeTypeArguments> getTypeArgumentsList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZenCodeTypeArguments.class);
  }

  @Override
  @NotNull
  public List<ZenCodeZCStringLiteral> getZCStringLiteralList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZenCodeZCStringLiteral.class);
  }

}
