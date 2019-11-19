package com.blamejared.zencodeplugin.components;

import com.blamejared.zencodeplugin.completion.*;
import com.intellij.openapi.fileChooser.*;
import com.intellij.openapi.options.*;
import com.intellij.openapi.ui.*;
import com.intellij.uiDesigner.core.*;
import org.jetbrains.annotations.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.function.*;

public class ZenCodeSettingsPanel implements Configurable {
    
    private static final Dimension noSize = new Dimension(-1, -1);
    
    private static void addFileChooser(JPanel upperPanel, int row, JPanel buttons, String name, String startValue, Consumer<String> folderConsumer, Runnable reloadListener) {
        final JTextField text = new JTextField(startValue);
        text.setEnabled(false);
        final TextFieldWithBrowseButton button = new TextFieldWithBrowseButton(text);
        upperPanel.add(button, new GridConstraints(row, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, noSize, noSize, noSize));
        
        button.addBrowseFolderListener(new TextBrowseFolderListener(new FileChooserDescriptor(false, true, false, false, false, false)) {
            @Override
            public void actionPerformed(ActionEvent e) {
                super.actionPerformed(e);
                folderConsumer.accept(text.getText());
                reloadListener.run();
            }
        });
        
        final JButton reloadButton = new JButton(String.format(Locale.ENGLISH, "Reload Known %s files", name));
        reloadButton.addActionListener(e -> reloadListener.run());
        buttons.add(reloadButton);
        
    }
    
    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return "ZenCode";
    }
    
    @Nullable
    @Override
    public JComponent createComponent() {
        final JPanel jPanel = new JPanel(new GridLayoutManager(2, 1));
        
        final JPanel upperPanel = new JPanel(new GridLayoutManager(3, 2));
        final JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        final ZenCodeProjectComponent zcProject = ZenCodeProjectComponent.getInstance();
        addFileChooser(upperPanel, 0, buttonPanel, "BEP", zcProject.getBracketFolderLocation(), zcProject::setBracketFolderLocation, () -> ZenCodeCompletionUtils.readBrackets(true));
        addFileChooser(upperPanel, 1, buttonPanel, "Methods", zcProject.getMethodFolderLocation(), zcProject::setMethodFolderLocation, () -> ZenCodeCompletionUtils.readMethods(true));
        addFileChooser(upperPanel, 2, buttonPanel, "Fields", zcProject.getFieldFolderLocation(), zcProject::setFieldFolderLocation, () -> ZenCodeCompletionUtils.readFields(true));
        
        
        jPanel.add(upperPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, noSize, noSize, noSize));
        jPanel.add(buttonPanel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, noSize, noSize, noSize));
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
