package org.apache.maven.archetypes.writer;


import org.apache.maven.archetypes.classes.AbstractModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class UserDataWriter extends AbstractWriter{

    void write(List<? extends AbstractModel<?>> list) {
        try (FileWriter dataWriter = new FileWriter(this.getFile())){
            String[] classNameArr = list.getFirst().getClass().toString().split("\\.");
            dataWriter.write(String.format("Тип объектов: %s\nКоличество объектов: %d\n", classNameArr[classNameArr.length-1], list.size()));
            for(Object o: list){
                dataWriter.write(o.toString());
                dataWriter.write("\n");
            }
        //До исключение дело не дойдёт, поскольку в методах setCatalog и setFileName (скрыты в getFile) требуется, чтобы каталог сущестовал
        //и имя файла было не занято
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setFieName(){
        if (catalog == null){
            System.out.println("Сначала необходимо выбрать каталог для сохранения!");
            this.setCatalog();
        }
        String fileName;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Введите желаемое имя файла: ");
            fileName = sc.nextLine();
            if ((new File(this.catalog +"\\" +fileName).exists())) {
                System.out.printf("Файл %s уже существует в каталоге %s, пожалуйста, введите другое имя файла\n", fileName, catalog);
            } else {
                this.fileName = fileName;
                break;
            }
        }
        this.file = new File(catalog +"\\" + fileName);

    }
    public File getFile() {
        if (file != null) return file;
        else {
            this.setFieName();
            return this.file;
        }
    }
}
