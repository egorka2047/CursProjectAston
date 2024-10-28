package org.apache.maven.archetypes.search.universalsearch;

import org.apache.maven.archetypes.classes.AbstractModel;

import java.util.List;

public class BinarySearch {
    public static  int binarySearch(List<? extends AbstractModel> lists, AbstractModel target) {
        int left = 0;
        int right = lists.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            AbstractModel midElement = lists.get(mid);

            int comparison = midElement.compareTo(target);
            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
