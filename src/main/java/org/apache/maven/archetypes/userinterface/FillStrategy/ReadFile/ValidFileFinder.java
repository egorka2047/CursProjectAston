package org.apache.maven.archetypes.userinterface.FillStrategy.ReadFile;

import java.io.File;

public class ValidFileFinder implements ChoiceCatalog, ChoiceFile {
    private String catalog, fileName;
    private File file;

    void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getCatalog() {
        return catalog;
    }

    public String getFileName() {
        return fileName;
    }

    public File getFile() {
        return file;
    }
}
