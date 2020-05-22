package com.blamejared.zencodeplugin.reference;

import com.blamejared.zencodeplugin.psi.*;
import com.blamejared.zencodeplugin.util.*;
import com.intellij.openapi.util.*;
import com.intellij.psi.*;
import com.intellij.refactoring.rename.*;
import com.intellij.usageView.*;
import org.jetbrains.annotations.*;

import java.util.*;

public class VariableNameRenameProcessor extends RenamePsiElementProcessor {
    
    @Override
    public boolean canProcessElement(@NotNull PsiElement element) {
        return element instanceof ZenCodeStatementVar;
    }
    
    @Override
    public void findCollisions(@NotNull PsiElement element, @NotNull String newName, @NotNull Map<? extends PsiElement, String> allRenames, @NotNull List<UsageInfo> result) {
        //TODO currently only looking upwards
        allRenames.forEach((e, name) -> {
            for(ZenCodeStatementVar variableName : ZenCodeUtil.getAllVariableDeclarations(e)) {
                if(Comparing.strEqual(name, variableName.getName())) {
                    result.add(new UnresolvableCollisionUsageInfo(variableName, e) {
                        @Override
                        public String getDescription() {
                            return String.format(Locale.ENGLISH, "New variable name '%s' hides existing variable", name);
                        }
                    });
                }
            }
        });
    }
}
