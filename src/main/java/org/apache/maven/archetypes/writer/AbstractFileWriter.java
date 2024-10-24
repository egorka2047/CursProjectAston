package org.apache.maven.archetypes.writer;

import java.io.File;

public abstract class AbstractFileWriter {
    String catalog, fileName;
    File file;

    public File getFile(){
        if(file == null){
            System.out.println("Сначала укажите желаемую директорию и имя файла");
            setFile();
        }
        return file;
    }
    abstract void setFile();
}
