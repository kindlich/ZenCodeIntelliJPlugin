package com.blamejared.zencodeplugin.components;

import com.blamejared.zencodeplugin.completion.BracketCompletionProvider;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.ui.TextBrowseFolderListener;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

public class ZenCodeSettingsPanel implements Configurable {
    
    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return "ZenCode";
    }
    
    @Nullable
    @Override
    public JComponent createComponent() {
        final JPanel jPanel = new JPanel(new GridLayoutManager(2, 2));
        
        //jPanel.setLayout(new GridLayoutManager(1, 2));
        final Dimension noSize = new Dimension(-1, -1);
        jPanel.add(new JLabel("Known BEP Folder: "), new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, noSize, noSize, noSize));
        
        final JTextField text = new JTextField(ZenCodeProjectComponent.getInstance().getBracketFolderLocation());
        text.setEnabled(false);
        final TextFieldWithBrowseButton button = new TextFieldWithBrowseButton(text);
        jPanel.add(button, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, noSize, noSize, noSize));
        button.addBrowseFolderListener(new TextBrowseFolderListener(new FileChooserDescriptor(false, true, false, false, false, false)) {
            @Override
            protected void onFileChosen(@NotNull VirtualFile chosenFile) {
                super.onFileChosen(chosenFile);
                ZenCodeProjectComponent.getInstance().setBracketFolderLocation(text.getText());
                BracketCompletionProvider.readBrackets(true);
            }
        });
    
        final JButton reloadButton = new JButton("Reload Known BEP files");
        jPanel.add(reloadButton, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, noSize, noSize, noSize));
        reloadButton.addActionListener(e -> BracketCompletionProvider.readBrackets(true));
        
        return jPanel;
        
    }
    
    @Override
    public boolean isModified() {
        return false;
    }
    
    @Override
    public void apply() throws ConfigurationException {
    
    }
}
