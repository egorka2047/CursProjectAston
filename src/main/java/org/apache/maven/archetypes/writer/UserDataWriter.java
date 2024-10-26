package org.apache.maven.archetypes.writer;


import org.apache.maven.archetypes.classes.AbstractModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**Основной метод класса - метод WRITE
 * Он запрашивает у пользователя каталог, где нужно создать файл и имя файла
 * В результате гарантируется, что каталог существует и в нем можно создавать файлы, а также выбранное имя файла не занято
 * После в созданный файл производится запись пользовательского неотфильтрованного набора данных в стандартном виде:
 *      - Тип объектов M
 *      - Количество объектов N
 *      - описание оюъектов (повторяется N раз в новой строке)**/

public class UserDataWriter extends AbstractFileWriter implements ChoosCatalog {

    public void write(List<? extends AbstractModel> list) {

        try (FileWriter dataWriter = new FileWriter(this.getFile())){
            String[] classNameArr = list.getFirst().getClass().toString().split("\\.");
            dataWriter.write(String.format("Тип объектов: %s\nКоличество объектов: %d\n", classNameArr[classNameArr.length-1], list.size()));

            for(Object o: list){
                dataWriter.write(o.toString());
                dataWriter.write("\n");
            }
        //До исключение дело не дойдёт, поскольку в методах setCatalog и setFileName требуется, чтобы каталог сущестовал,
        //в него можно было записывать файлы
        //и имя файла было не занято
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setFieName(){

        if (catalog == null){
            setCatalog(this);
        }

        String fileName;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Введите желаемое имя файла: ");
            fileName = sc.nextLine();

            if ((new File(this.catalog +"\\" +fileName).exists())) {
                System.out.printf("Файл %s уже существует в каталоге %s, пожалуйста, введите другое имя файла\n", fileName, catalog);
            }
            else {
                this.fileName = fileName;
                break;
            }
        }
    }
    @Override
    public void setFile() {
            this.setFieName();
            this.file = new File(catalog +"\\" + fileName);
    }
}
