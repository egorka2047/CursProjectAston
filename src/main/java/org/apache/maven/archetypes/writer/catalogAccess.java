package org.apache.maven.archetypes.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public final class catalogAccess {
    public static boolean writeAccessible(File file){
        try{
            File testFile = new File(file, "test.txt");
            testFile.createNewFile();
            return testFile.delete();
        } catch (IOException e) {
            return false;
        }
    }
}
