package org.apache.maven.archetypes.sort.strategySort;

import org.apache.maven.archetypes.classes.Bus;
import java.util.List;
public class BusSortWithStrategy implements SortWithStrategy<Bus> {
    @Override
    public void strategySort(List<Bus> list) {
        for (int i = 0; i < list.size(); i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Bus temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);
            }
        }
    }
}
