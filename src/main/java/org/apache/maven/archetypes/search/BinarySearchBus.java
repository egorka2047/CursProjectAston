package org.apache.maven.archetypes.search;

import org.apache.maven.archetypes.classes.Bus;

import java.util.List;

public class BinarySearchBus implements BinarySearchInterface<Bus> {

    @Override
    public int binarySearch(List<Bus> buses, Bus target) {
        int left = 0;
        int right = buses.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Bus midBus = buses.get(mid);

            int comparison = midBus.compareTo(target);
            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -(left + 1);
    }

}
