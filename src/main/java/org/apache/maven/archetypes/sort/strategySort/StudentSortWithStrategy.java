package org.apache.maven.archetypes.sort.strategySort;

import org.apache.maven.archetypes.classes.Student;
import java.util.List;

/**  Сортировка с использованием Стратегии добавлена в экспериментальных целях (пользоваться обычный - class NaturalSort) **/
public class StudentSortWithStrategy implements SortWithStrategy<Student> {
    @Override
    public void strategySort(List<Student> list) {
        for (int i = 0; i < list.size(); i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Student temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);
            }
        }
    }
}