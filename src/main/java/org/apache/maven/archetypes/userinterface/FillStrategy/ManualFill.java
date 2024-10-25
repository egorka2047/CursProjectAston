package org.apache.maven.archetypes.userinterface.FillStrategy;

import org.apache.maven.archetypes.classes.AbstractModel;

import java.util.ArrayList;
import java.util.List;

public class ManualFill extends FillStrategy{

    public ManualFill() {
        super("Ручной ввод данных", 1);
    }

    @Override
    public void runCommand(List<? super AbstractModel<?>> list) {

    }
}
