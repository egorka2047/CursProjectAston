package org.apache.maven.archetypes;

import java.io.*;
import java.awt.GraphicsEnvironment;
import java.net.URISyntaxException;

//Как будто без этого JAR файл не удается открыть в консоли
public class ConsoleOpen{
    public static void main (String [] args) throws IOException, InterruptedException, URISyntaxException{
        Console console = System.console();
        if(console == null && !GraphicsEnvironment.isHeadless()){
            String filename = main.class.getProtectionDomain().getCodeSource().getLocation().toString().substring(6);
            Runtime.getRuntime().exec(new String[]{"cmd","/c","start","cmd","/k","java -jar \"" + filename + "\""});
        }else{
            main.main(new String[0]);
            System.out.println("Program has ended, please type 'exit' to close the console");
        }
    }
}
