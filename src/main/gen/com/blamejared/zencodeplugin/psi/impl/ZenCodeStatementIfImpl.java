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

public class ZenCodeStatementIfImpl extends ASTWrapperPsiElement implements ZenCodeStatementIf {

  public ZenCodeStatementIfImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ZenCodeVisitor visitor) {
    visitor.visitStatementIf(this);
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
  public List<ZenCodeStatementBlock> getStatementBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZenCodeStatementBlock.class);
  }

  @Override
  @NotNull
  public List<ZenCodeStatementBreak> getStatementBreakList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZenCodeStatementBreak.class);
  }

  @Override
  @NotNull
  public List<ZenCodeStatementContinue> getStatementContinueList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZenCodeStatementContinue.class);
  }

  @Override
  @NotNull
  public List<ZenCodeStatementDoWhile> getStatementDoWhileList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZenCodeStatementDoWhile.class);
  }

  @Override
  @NotNull
  public List<ZenCodeStatementExpression> getStatementExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZenCodeStatementExpression.class);
  }

  @Override
  @NotNull
  public List<ZenCodeStatementForEach> getStatementForEachList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZenCodeStatementForEach.class);
  }

  @Override
  @NotNull
  public List<ZenCodeStatementIf> getStatementIfList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZenCodeStatementIf.class);
  }

  @Override
  @NotNull
  public List<ZenCodeStatementLock> getStatementLockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZenCodeStatementLock.class);
  }

  @Override
  @NotNull
  public List<ZenCodeStatementReturn> getStatementReturnList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZenCodeStatementReturn.class);
  }

  @Override
  @NotNull
  public List<ZenCodeStatementSwitch> getStatementSwitchList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZenCodeStatementSwitch.class);
  }

  @Override
  @NotNull
  public List<ZenCodeStatementTryCatch> getStatementTryCatchList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZenCodeStatementTryCatch.class);
  }

  @Override
  @NotNull
  public List<ZenCodeStatementVar> getStatementVarList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZenCodeStatementVar.class);
  }

  @Override
  @NotNull
  public List<ZenCodeStatementWhileDo> getStatementWhileDoList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ZenCodeStatementWhileDo.class);
  }

}
