package org.apache.maven.archetypes.search;

import org.apache.maven.archetypes.classes.Student;

import java.util.List;

public class BinarySearchStudent implements BinarySearch<Student> {
    @Override
    public int binarySearch(List<Student> students, Student target) {
        int left = 0;
        int right = students.size() - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            Student midStudent = students.get(middle);

            int comparison = midStudent.compareTo(target);
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
