package com.blamejared.zencodeplugin.language;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class ZenCodeFileTypeFactory extends FileTypeFactory {
    
    @Override
    public void createFileTypes(@NotNull FileTypeConsumer consumer) {
        consumer.consume(ZenCodeFileType.INSTANCE);
    }
}
