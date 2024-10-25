package org.apache.maven.archetypes.userinterface.FillStrategy;

import org.apache.maven.archetypes.classes.AbstractModel;

import java.util.ArrayList;
import java.util.List;

public class FillFromFile extends FillStrategy{

    public FillFromFile() {
        super("Чтение данных из файла", 2);
    }

    @Override
    public void runCommand(List<? extends AbstractModel<?>> list) {

    }

}
