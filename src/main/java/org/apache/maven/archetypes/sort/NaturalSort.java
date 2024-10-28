package org.apache.maven.archetypes.sort;

import org.apache.maven.archetypes.classes.AbstractModel;

import java.util.List;

public class NaturalSort {

    private static String sortName = "Классическая сортировка выбором";

    public static String getSortName() {
        return sortName;
    }

    public static void sort(List<AbstractModel> list) {
        for (int i = 0; i < list.size(); i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                AbstractModel temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);
            }
        }
    }

}