package com.blamejared.zencodeplugin.components;

import com.intellij.ide.util.*;
import com.intellij.openapi.application.*;

public class ZenCodeProjectComponent {
    
    private static final String DEFAULT_BEP_DUMP_LOCATION = "./../logs/dumps/brackets";
    private static final String DEFAULT_METHOD_DUMP_LOCATION = "./../logs/dumps/method";
    private static final String DEFAULT_FIELD_DUMP_LOCATION = "./../logs/dumps/field";
    private static final String BEP_DUMP_LOCATION_PROPERTY_NAME = "zencodeplugin.folder_bep";
    private static final String METHOD_DUMP_LOCATION_PROPERTY_NAME = "zencodeplugin.folder_method";
    private static final String FIELD_DUMP_LOCATION_PROPERTY_NAME = "zencodeplugin.folder_field";
    private final PropertiesComponent component;
    
    public ZenCodeProjectComponent(PropertiesComponent component) {
        
        this.component = component;
    }
    
    public static ZenCodeProjectComponent getInstance() {
        return ApplicationManager.getApplication().getComponent(ZenCodeProjectComponent.class);
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
    
    public String getMethodFolderLocation() {
        final String value = component.getValue(METHOD_DUMP_LOCATION_PROPERTY_NAME, "");
        if(!value.isEmpty()) {
            return value;
        }
        setBracketFolderLocation(DEFAULT_METHOD_DUMP_LOCATION);
        return METHOD_DUMP_LOCATION_PROPERTY_NAME;
    }
    
    void setMethodFolderLocation(String location) {
        component.setValue(METHOD_DUMP_LOCATION_PROPERTY_NAME, location);
    }
    
    public String getFieldFolderLocation() {
        final String value = component.getValue(FIELD_DUMP_LOCATION_PROPERTY_NAME, "");
        if(!value.isEmpty()) {
            return value;
        }
        setBracketFolderLocation(DEFAULT_FIELD_DUMP_LOCATION);
        return FIELD_DUMP_LOCATION_PROPERTY_NAME;
    }
    
    public void setFieldFolderLocation(String location) {
        component.setValue(FIELD_DUMP_LOCATION_PROPERTY_NAME, location);
    }
}
