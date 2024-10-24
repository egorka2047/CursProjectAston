package org.apache.maven.archetypes.writer;

import java.io.File;

public abstract class AbstractFileWriter {

    String catalog, fileName;
    File file;

    public File getFile(){
        if(file == null){
            setFile();
        }
        return file;
    }
    abstract void setFile();
}
