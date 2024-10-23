package org.apache.maven.archetypes.writer;


import org.apache.maven.archetypes.classes.AbstractModel;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class UserDataWriter extends AbstractWriter{
    @Override
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
}
