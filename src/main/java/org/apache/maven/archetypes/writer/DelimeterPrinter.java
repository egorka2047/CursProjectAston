package org.apache.maven.archetypes.writer;

public class DelimeterPrinter {
    public static String printDelimeter(Character cr, Integer numOfChar, Integer numOfLine){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < numOfChar; i++) {
            stringBuilder.append(cr);
        }
        StringBuilder lineBuilder = new StringBuilder();
        String line = stringBuilder.toString();
        for (int i = 0; i < numOfLine; i++) {
            lineBuilder.append(line);
            lineBuilder.append("\n");
        }
        return lineBuilder.toString();
    }
}
