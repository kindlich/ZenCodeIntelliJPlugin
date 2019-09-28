package com.blamejared.zencodeplugin.components;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.application.ApplicationManager;

public class ZenCodeProjectComponent {
    
    private static final String DEFAULT_BEP_DUMP_LOCATION = "./../logs/dumps/brackets";
    private static final String BEP_DUMP_LOCATION_PROPERTY_NAME = "zencodeplugin.folder_bep";
    private final PropertiesComponent component;
    
    public static ZenCodeProjectComponent getInstance() {
        return ApplicationManager.getApplication().getComponent(ZenCodeProjectComponent.class);
    }
    
    public ZenCodeProjectComponent(PropertiesComponent component) {
        
        this.component = component;
    }
    
    public PropertiesComponent getComponent() {
        return component;
    }
    
    public String getBracketFolderLocation() {
        final String value = component.getValue(BEP_DUMP_LOCATION_PROPERTY_NAME, "");
        if(!value.isEmpty()) {
            return value;
        }
        setBracketFolderLocation(DEFAULT_BEP_DUMP_LOCATION);
        return DEFAULT_BEP_DUMP_LOCATION;
    }
    
    void setBracketFolderLocation(String location) {
        component.setValue(BEP_DUMP_LOCATION_PROPERTY_NAME, location);
    }
}
