package org.apache.maven.archetypes.writer;

import org.apache.maven.archetypes.classes.AbstractModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SortedDataWriter extends AbstractWriter{

    void write(List<? extends AbstractModel<?>> sortedList, String sotrName) {
        String[] classNameArr = sortedList.getFirst().getClass().toString().split("\\.");
        String className = classNameArr[classNameArr.length-1];
        try (FileWriter dataWriter = new FileWriter(className + "Sorted.txt", true)){
            dataWriter.write(String.format("Тип объектов: %s\n" +
                    "Количество объектов: %d\n" +
                    "Метод сортировки: %s\n" +
                    "Дата и время сохранения: %s\n",className, sortedList.size(),sotrName, DateTimeGetter.getDataTime()));
            for(Object o: sortedList){
                dataWriter.write(o.toString());
                dataWriter.write("\n");
            }
            dataWriter.write(DelimeterPrinter.printDelimeter('=',50,2));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
