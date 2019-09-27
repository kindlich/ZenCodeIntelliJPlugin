// This is a generated file. Not intended for manual editing.
package com.blamejared.zencodeplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ZenCodeStatementForEach extends PsiElement {

  @NotNull
  ZenCodeExpression getExpression();

  @Nullable
  ZenCodeStatementBlock getStatementBlock();

  @Nullable
  ZenCodeStatementBreak getStatementBreak();

  @Nullable
  ZenCodeStatementContinue getStatementContinue();

  @Nullable
  ZenCodeStatementDoWhile getStatementDoWhile();

  @Nullable
  ZenCodeStatementExpression getStatementExpression();

  @Nullable
  ZenCodeStatementForEach getStatementForEach();

  @Nullable
  ZenCodeStatementIf getStatementIf();

  @Nullable
  ZenCodeStatementLock getStatementLock();

  @Nullable
  ZenCodeStatementReturn getStatementReturn();

  @Nullable
  ZenCodeStatementSwitch getStatementSwitch();

  @Nullable
  ZenCodeStatementTryCatch getStatementTryCatch();

  @Nullable
  ZenCodeStatementVar getStatementVar();

  @Nullable
  ZenCodeStatementWhileDo getStatementWhileDo();

}
