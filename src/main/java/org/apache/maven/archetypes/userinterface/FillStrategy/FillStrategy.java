package org.apache.maven.archetypes.userinterface.FillStrategy;

import org.apache.maven.archetypes.classes.AbstractModel;

import java.util.List;

public abstract class FillStrategy implements  Comparable<FillStrategy>, Selectable{

    private final String fillStrategyName;
    private final Integer fillStrategyCommand;

    public FillStrategy(String fillStrategyName, Integer fillStrategyComand){
        this.fillStrategyName = fillStrategyName;
        this.fillStrategyCommand = fillStrategyComand;
    }

    public abstract void runCommand(List<? super AbstractModel> list);

    public String getFillStrategyName() {
        return fillStrategyName;
    }

    public Integer getFillStrategyCommand() {
        return fillStrategyCommand;
    }

    @Override
    public int compareTo(FillStrategy o) {
        return this.fillStrategyCommand.compareTo(o.getFillStrategyCommand());
    }

    @Override
    public Integer getComandNumber() {
        return this.fillStrategyCommand;
    }

}
