// This is a generated file. Not intended for manual editing.
package com.blamejared.zencodeplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ZenCodeStatementSwitch extends PsiElement {

  @NotNull
  ZenCodeExpression getExpression();

  @NotNull
  List<ZenCodeStatementBlock> getStatementBlockList();

  @NotNull
  List<ZenCodeStatementBreak> getStatementBreakList();

  @NotNull
  List<ZenCodeStatementContinue> getStatementContinueList();

  @NotNull
  List<ZenCodeStatementDoWhile> getStatementDoWhileList();

  @NotNull
  List<ZenCodeStatementExpression> getStatementExpressionList();

  @NotNull
  List<ZenCodeStatementForEach> getStatementForEachList();

  @NotNull
  List<ZenCodeStatementIf> getStatementIfList();

  @NotNull
  List<ZenCodeStatementLock> getStatementLockList();

  @NotNull
  List<ZenCodeStatementReturn> getStatementReturnList();

  @NotNull
  List<ZenCodeStatementSwitch> getStatementSwitchList();

  @NotNull
  List<ZenCodeStatementTryCatch> getStatementTryCatchList();

  @NotNull
  List<ZenCodeStatementVar> getStatementVarList();

  @NotNull
  List<ZenCodeStatementWhileDo> getStatementWhileDoList();

}
