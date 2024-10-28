package org.apache.maven.archetypes.userinterface.FillStrategy;

import org.apache.maven.archetypes.classes.AbstractModel;
import org.apache.maven.archetypes.userinterface.FillStrategy.ReadFile.CastomFileReader;
import org.apache.maven.archetypes.userinterface.FillStrategy.ReadFile.ChoiceCatalog;
import org.apache.maven.archetypes.userinterface.FillStrategy.ReadFile.ChoiceFile;
import org.apache.maven.archetypes.userinterface.FillStrategy.ReadFile.ValidFileFinder;

import java.util.List;

public class FillFromFile extends FillStrategy{

    public FillFromFile() {
        super("Чтение данных из файла пользователя", 2);
    }

    @Override
    public void runCommand(List<? super AbstractModel> list) {
        ValidFileFinder validFileFinder = new ValidFileFinder();
        ChoiceCatalog.setCatalog(validFileFinder);
        ChoiceFile.setFile(validFileFinder);
        CastomFileReader.read(validFileFinder.getFile(), list);
    }

}
