package org.apache.maven.archetypes.userinterface.FillStrategy;

import org.apache.maven.archetypes.classes.AbstractModel;
import org.apache.maven.archetypes.fillingAnArray.FillingAnArrayFromFile;

import java.io.FileNotFoundException;
import java.util.List;

public class FillFromStandartFile extends FillStrategy{
    public FillFromStandartFile() {
        super("Заполнение из дефолтных файлов", 4);
    }

    @Override
    public void runCommand(List<? super AbstractModel> list) {
        try {
            FillingAnArrayFromFile.getArrayOjects(list);
        } catch (FileNotFoundException e) {
            System.out.println("К сожалению на вашем компьютере нет стандартных файлов с данными");
        }

    }
}
