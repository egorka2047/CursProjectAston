package org.apache.maven.archetypes.writer;

import org.apache.maven.archetypes.classes.AbstractModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**Класс предназначен для записи отсортированных массивов кастомных классов с указанием даты записи, типа объектов
 * количества объектов и метода сортировки
 * Для записи в метод необходимо передать следующие параметры:
 * sortedList - отсортированный массив кастомных классов, наследующих класс AbstractModel
 * sortName - название алгоритма сортировки
 * Метод автоматически определяет с каким кастомным классом он работает по переданному list
 * В зависимости от типа объекта запись происходит в специальный файл, имеющий имя ObjectClassNameSorted.txt
 * Если файл отсутствует, то он генерируется, если уже есть, то дополняется новыми записями**/

public class SortedDataWriter extends AbstractFileWriter {

    void write(List<? extends AbstractModel<?>> sortedList, String sotrName) {

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
                            Метод сортировки: %s
                            """
                    ,DateTimeGetter.getDataTime(), className, sortedList.size(),sotrName));

            for(int i = 0; i < sortedList.size(); i++){
                dataWriter.write(String.format("%d) ", i+1));
                dataWriter.write(sortedList.get(i).toString());
                dataWriter.write("\n");
            }

            dataWriter.write(DelimeterPrinter.printDelimeter('=',50,2));
        }
        catch (IOException e) {
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
