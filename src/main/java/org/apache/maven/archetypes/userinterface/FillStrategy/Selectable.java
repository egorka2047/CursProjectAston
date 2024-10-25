package org.apache.maven.archetypes.userinterface.FillStrategy;

import org.apache.maven.archetypes.classes.AbstractModel;

import java.util.List;

public interface Selectable {
    Integer getComandNumber();

    void runCommand(List<? extends AbstractModel<?>> list);
}
