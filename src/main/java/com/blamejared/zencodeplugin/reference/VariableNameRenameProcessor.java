package com.blamejared.zencodeplugin.reference;

import com.blamejared.zencodeplugin.psi.ZenCodeDeclareVariableName;
import com.blamejared.zencodeplugin.psi.ZenCodeVariableName;
import com.blamejared.zencodeplugin.util.ZenCodeUtil;
import com.intellij.openapi.util.Comparing;
import com.intellij.psi.PsiElement;
import com.intellij.refactoring.rename.CollisionUsageInfo;
import com.intellij.refactoring.rename.RenamePsiElementProcessor;
import com.intellij.refactoring.rename.UnresolvableCollisionUsageInfo;
import com.intellij.usageView.UsageInfo;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public class VariableNameRenameProcessor extends RenamePsiElementProcessor {
    
    @Override
    public boolean canProcessElement(@NotNull PsiElement element) {
        return element instanceof ZenCodeDeclareVariableName;
    }
    
    @Override
    public void findCollisions(@NotNull PsiElement element, @NotNull String newName, @NotNull Map<? extends PsiElement, String> allRenames, @NotNull List<UsageInfo> result) {
        //TODO currently only looking upwards
        allRenames.forEach((e, name) -> {
            for(ZenCodeDeclareVariableName variableName : ZenCodeUtil.getAllVariableDeclarations(e)) {
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
