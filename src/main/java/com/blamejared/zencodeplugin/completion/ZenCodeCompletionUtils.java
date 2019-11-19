package com.blamejared.zencodeplugin.completion;

import com.blamejared.zencodeplugin.completion.types.*;
import com.blamejared.zencodeplugin.components.*;
import com.intellij.openapi.util.*;

import java.io.*;
import java.util.*;

public class ZenCodeCompletionUtils {
    
    public static final Key<ZenCodeCompletionTypeInfo> TYPE_KEY = new Key<>("ZenCodeCompletionTypeInfo");
    private static final ZenCodeCompletionTypeRegistry registry = new ZenCodeCompletionTypeRegistry();
    private static Map<String, Collection<String>> bracketExpressions = null;
    private static Map<String, Map<String, Collection<String>>> methods = null;
    private static Map<String, Collection<String>> fields = null;
    
    public static void readBrackets(boolean forced) {
        if(!forced && bracketExpressions != null)
            return;
        
        final File dumpFolder = new File(ZenCodeProjectComponent.getInstance().getBracketFolderLocation());
        
        
        if(dumpFolder.exists() && dumpFolder.isDirectory()) {
            final File[] files = dumpFolder.listFiles();
            if(files == null)
                return;
            
            bracketExpressions = new HashMap<>();
            
            for(File file : files) {
                if(!file.isFile()) {
                    continue;
                }
                final String name;
                {
                    String n = file.getName();
                    name = n.endsWith(".txt") ? n.substring(0, n.length() - 4) : n;
                }
                
                if(!bracketExpressions.containsKey(name)) {
                    bracketExpressions.put(name, new ArrayList<>());
                }
                
                try(final BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    reader.lines().forEach(s -> bracketExpressions.get(name).add(s));
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static Map<String, Collection<String>> getBracketExpressions() {
        return bracketExpressions;
    }
    
    public static void readMethods(boolean forced) {
        if(!forced && methods != null)
            return;
        
        final File dumpFolder = new File(ZenCodeProjectComponent.getInstance().getMethodFolderLocation());
        if(dumpFolder.exists() && dumpFolder.isDirectory()) {
            final File[] files = dumpFolder.listFiles();
            if(files == null) {
                return;
            }
            
            methods = new HashMap<>();
            
            for(File file : files) {
                if(!file.isFile())
                    continue;
                final String name = file.getName();
                final Map<String, Collection<String>> foundMethods = methods.computeIfAbsent(name, s -> new HashMap<>());
                
                try(final BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    while(reader.ready()) {
                        final String[] split = reader.readLine().split("\\(", 2);
                        //TODO replace with type info/Method header
                        foundMethods.computeIfAbsent(split[0], s -> new ArrayList<>()).add(split[1]);
                    }
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static void readFields(boolean forced) {
        if(!forced && fields != null) {
            return;
        }
        
        final File dumpFolder = new File(ZenCodeProjectComponent.getInstance().getMethodFolderLocation());
        if(dumpFolder.exists() && dumpFolder.isDirectory()) {
            
            fields = new HashMap<>();
            final File[] files = dumpFolder.listFiles();
            if(files != null) {
                
                for(File file : files) {
                    if(file.isFile())
                        try(final BufferedReader reader = new BufferedReader(new FileReader(file))) {
                            while(reader.ready()) {
                                final String[] split = reader.readLine().split(":", 2);
                                fields.computeIfAbsent(split[0], s -> new ArrayList<>()).add(split[1]);
                            }
                        } catch(IOException e) {
                            e.printStackTrace();
                        }
                }
            }
            
        }
    }
    
    public static ZenCodeCompletionTypeInfo getTypeForBracket(String text) {
        readBrackets(false);
        if(bracketExpressions != null) {
            for(Map.Entry<String, Collection<String>> stringCollectionEntry : bracketExpressions.entrySet()) {
                if(stringCollectionEntry.getValue().contains(text))
                    return getTypeForName(stringCollectionEntry.getKey());
            }
        }
        
        return null;
    }
    
    
    private static ZenCodeCompletionTypeInfo getTypeForName(String zenName) {
        return registry.getType(zenName);
    }
}
