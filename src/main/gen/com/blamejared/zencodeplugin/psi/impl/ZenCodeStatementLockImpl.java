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

public class ZenCodeStatementLockImpl extends ASTWrapperPsiElement implements ZenCodeStatementLock {

  public ZenCodeStatementLockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ZenCodeVisitor visitor) {
    visitor.visitStatementLock(this);
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
  @Nullable
  public ZenCodeStatementBlock getStatementBlock() {
    return findChildByClass(ZenCodeStatementBlock.class);
  }

  @Override
  @Nullable
  public ZenCodeStatementBreak getStatementBreak() {
    return findChildByClass(ZenCodeStatementBreak.class);
  }

  @Override
  @Nullable
  public ZenCodeStatementContinue getStatementContinue() {
    return findChildByClass(ZenCodeStatementContinue.class);
  }

  @Override
  @Nullable
  public ZenCodeStatementDoWhile getStatementDoWhile() {
    return findChildByClass(ZenCodeStatementDoWhile.class);
  }

  @Override
  @Nullable
  public ZenCodeStatementExpression getStatementExpression() {
    return findChildByClass(ZenCodeStatementExpression.class);
  }

  @Override
  @Nullable
  public ZenCodeStatementForEach getStatementForEach() {
    return findChildByClass(ZenCodeStatementForEach.class);
  }

  @Override
  @Nullable
  public ZenCodeStatementIf getStatementIf() {
    return findChildByClass(ZenCodeStatementIf.class);
  }

  @Override
  @Nullable
  public ZenCodeStatementLock getStatementLock() {
    return findChildByClass(ZenCodeStatementLock.class);
  }

  @Override
  @Nullable
  public ZenCodeStatementReturn getStatementReturn() {
    return findChildByClass(ZenCodeStatementReturn.class);
  }

  @Override
  @Nullable
  public ZenCodeStatementSwitch getStatementSwitch() {
    return findChildByClass(ZenCodeStatementSwitch.class);
  }

  @Override
  @Nullable
  public ZenCodeStatementTryCatch getStatementTryCatch() {
    return findChildByClass(ZenCodeStatementTryCatch.class);
  }

  @Override
  @Nullable
  public ZenCodeStatementVar getStatementVar() {
    return findChildByClass(ZenCodeStatementVar.class);
  }

  @Override
  @Nullable
  public ZenCodeStatementWhileDo getStatementWhileDo() {
    return findChildByClass(ZenCodeStatementWhileDo.class);
  }

}
