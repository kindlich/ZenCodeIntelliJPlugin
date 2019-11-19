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

public class ZenCodeExpressionAssignImpl extends ASTWrapperPsiElement implements ZenCodeExpressionAssign {

  public ZenCodeExpressionAssignImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ZenCodeVisitor visitor) {
    visitor.visitExpressionAssign(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ZenCodeVisitor) accept((ZenCodeVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ZenCodeAssignOperator getAssignOperator() {
    return findChildByClass(ZenCodeAssignOperator.class);
  }

  @Override
  @Nullable
  public ZenCodeExpressionAssign getExpressionAssign() {
    return findChildByClass(ZenCodeExpressionAssign.class);
  }

  @Override
  @NotNull
  public ZenCodeExpressionConditional getExpressionConditional() {
    return findNotNullChildByClass(ZenCodeExpressionConditional.class);
  }

}
