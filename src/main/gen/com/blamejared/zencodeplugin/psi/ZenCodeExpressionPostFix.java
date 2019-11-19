// This is a generated file. Not intended for manual editing.
package com.blamejared.zencodeplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ZenCodeExpressionPostFix extends PsiElement {

  @NotNull
  List<ZenCodeCallArguments> getCallArgumentsList();

  @NotNull
  List<ZenCodeExpressionAssign> getExpressionAssignList();

  @NotNull
  ZenCodeExpressionPrimary getExpressionPrimary();

  @NotNull
  List<ZenCodeLambdaBody> getLambdaBodyList();

  @NotNull
  List<ZenCodeType> getTypeList();

  @NotNull
  List<ZenCodeTypeArguments> getTypeArgumentsList();

  @NotNull
  List<ZenCodeZCStringLiteral> getZCStringLiteralList();

}
