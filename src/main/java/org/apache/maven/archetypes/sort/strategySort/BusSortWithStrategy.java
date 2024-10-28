package org.apache.maven.archetypes.sort.strategySort;

import org.apache.maven.archetypes.classes.Bus;
import java.util.List;

/**  Сортировка с использованием Стратегии добавлена в экспериментальных целях (пользоваться обычный - class NaturalSort)
 * Специальная сортировка Bus будет опираться на поле route: с четными сортируются в натуральном порядке, с нечетными не перемещаются **/
public class BusSortWithStrategy implements SortWithStrategy<Bus> {
    @Override
    public void strategySort(List<Bus> list) {
        for (int i = 0; i < list.size(); i++) {
            while (i < (list.size()-1)){
                if ((list.get(i).getRoute()%2) == 0) break;
                else i++;
            }
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                while (j < list.size()-1){
                    if (list.get(j).getRoute()%2 == 0) break;
                    else j++;
                }
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