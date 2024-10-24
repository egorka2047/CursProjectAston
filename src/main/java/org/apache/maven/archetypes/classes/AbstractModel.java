package org.apache.maven.archetypes.classes;

import org.apache.maven.archetypes.sort.strategySort.SortWithStrategy;
import java.util.List;

public abstract class AbstractModel<T> implements Comparable<T>{
    public SortWithStrategy sortWithStrategy;
    public void strategySort(List<? extends AbstractModel<T>> list) {
        sortWithStrategy.strategySort(list);
    }
    @Override
    public int compareTo(T o) {
        return 0;
    }
}