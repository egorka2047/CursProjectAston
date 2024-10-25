package org.apache.maven.archetypes.userinterface.FillStrategy;

import org.apache.maven.archetypes.classes.AbstractModel;

import java.util.List;

public class ExitProg extends  FillStrategy{

    public ExitProg() {
        super("ВЫХОД ИЗ ПРОГРАММЫ", 0);
    }

    @Override
    public void runCommand(List<? extends AbstractModel<?>> list) {
        System.out.println("Программа была завершена");
        System.exit(0);
    }
}
