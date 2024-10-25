package org.apache.maven.archetypes.userinterface.FillStrategy;

import org.apache.maven.archetypes.classes.AbstractModel;

import java.util.ArrayList;
import java.util.List;

public class RandomFill extends FillStrategy{

    public RandomFill() {
        super("Случайная генерация данных", 3);
    }

    @Override
    public void runCommand(List<? extends AbstractModel<?>> list) {
    }
}
