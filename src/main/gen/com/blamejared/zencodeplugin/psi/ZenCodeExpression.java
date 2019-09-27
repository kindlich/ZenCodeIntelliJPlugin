// This is a generated file. Not intended for manual editing.
package com.blamejared.zencodeplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ZenCodeExpression extends PsiElement {

  @NotNull
  List<ZenCodeExpression> getExpressionList();

  @NotNull
  List<ZenCodeExpressionBEP> getExpressionBEPList();

  @NotNull
  List<ZenCodeStatementBlock> getStatementBlockList();

  @NotNull
  List<ZenCodeType> getTypeList();

  @NotNull
  List<ZenCodeZCStringLiteral> getZCStringLiteralList();

}
