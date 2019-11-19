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

public class ZenCodeExpressionMatchImpl extends ASTWrapperPsiElement implements ZenCodeExpressionMatch {

  public ZenCodeExpressionMatchImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ZenCodeVisitor visitor) {
    visitor.visitExpressionMatch(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ZenCodeVisitor) accept((ZenCodeVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public ZenCodeExpression getExpression() {
    return findNotNullChildByClass(ZenCodeExpression.class);
  }

  @Override
  @NotNull
  public List<ZenCodeMatchCase> getMatchCaseList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZenCodeMatchCase.class);
  }

}
