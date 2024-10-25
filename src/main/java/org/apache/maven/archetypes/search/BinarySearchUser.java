package org.apache.maven.archetypes.search;

import org.apache.maven.archetypes.classes.User;

import java.util.List;

public class BinarySearchUser implements BinarySearch<User> {
    @Override
    public int binarySearch(List<User> users, User target) {
        int left = 0;
        int right = users.size() - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            User midUser = users.get(middle);

            int comparison = midUser.compareTo(target);
            if (comparison == 0) {
                return middle;
            } else if (comparison < 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -(left + 1);
    }
}
