// This is a generated file. Not intended for manual editing.
package com.blamejared.zencodeplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;

public interface ZenCodeDeclareVariableName extends PsiNameIdentifierOwner {

  @NotNull
  PsiElement getTIdentifier();

  String getName();

  PsiElement setName(String newName);

  @Nullable
  PsiElement getNameIdentifier();

}
