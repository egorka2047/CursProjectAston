package org.apache.maven.archetypes.userinterface;

import org.apache.maven.archetypes.userinterface.FillStrategy.*;

import java.util.List;

public class FilllSelect implements UserSelect{
    static List<FillStrategy> fillStrategies = List.of(new ManualFill(), new FillFromFile(), new RandomFill(), new ExitProg());

    @Override
    public Selectable startSelect() {
        System.out.println("Выберите способ добавления элементов:");
        fillStrategies.stream().sorted().forEach(el -> System.out.printf("%d) %s\n", el.getFillStrategyCommand(),el.getFillStrategyName()));
        return CommandChoice.choice(fillStrategies);
    }
}
