package org.apache.maven.archetypes.writer;

import org.apache.maven.archetypes.classes.AbstractModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteSearchResult extends AbstractFileWriter{

    void write(List<? extends AbstractModel<?>> sortedList, Integer foundIndex) {
        String[] classNameArr = sortedList.getFirst().getClass().toString().split("\\.");
        String className = classNameArr[classNameArr.length-1];
        this.fileName = className + "Sorted.txt";
        //this.catalog = "";//По дефолту длясохранения результатов сортировки будет выбираться папка, гдерасположено приложение
        setFile();
        try (FileWriter dataWriter = new FileWriter(getFile(), true)){
            dataWriter.write(String.format("""
                            Дата и время сохранения: %s
                            Тип объектов: %s
                            Количество объектов: %d
                            Метод сортировки: NaturalSort
                            """
                    ,DateTimeGetter.getDataTime(), className, sortedList.size()));
            if (foundIndex == -1) dataWriter.write("Искомый объект не найден\n");
            for(int i = 0; i < sortedList.size(); i++){
                dataWriter.write(String.format("%d) ", i+1));
                dataWriter.write(sortedList.get(i).toString());
                if (i == foundIndex){
                    dataWriter.write("  <============== Искомый объект ============");
                }
                dataWriter.write("\n");
            }
            dataWriter.write(DelimeterPrinter.printDelimeter('=',50,2));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    void setFile() {
        if (catalog != null){
            this.file = new File(new File(catalog), fileName);
        }
        else this.file = new File(fileName);
    }
}
