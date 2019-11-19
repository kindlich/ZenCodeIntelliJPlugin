// This is a generated file. Not intended for manual editing.
package com.blamejared.zencodeplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ZenCodeExpressionMatch extends PsiElement {

  @NotNull
  ZenCodeExpression getExpression();

  @NotNull
  List<ZenCodeMatchCase> getMatchCaseList();

}
