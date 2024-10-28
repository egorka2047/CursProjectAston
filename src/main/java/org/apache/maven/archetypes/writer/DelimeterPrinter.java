package org.apache.maven.archetypes.writer;


/**Создано для быстрого и удобного создания разделителей в текстовом файле
 * cr - каким символом будет рисоваться разедлитель
 * numOfChar - сколько символов будет содержаться в одной строке (длина разделителя)
 * numOfLine - количество линий в рзделителе**/

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
