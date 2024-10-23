package org.apache.maven.archetypes.sort.strategySort;

import org.apache.maven.archetypes.classes.AbstractModel;

import java.util.List;

public interface SortWithStrategy<T extends AbstractModel<T>> {
    void strategySort(List<T> list);
}



