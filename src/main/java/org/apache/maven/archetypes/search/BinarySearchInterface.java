package org.apache.maven.archetypes.search;

import org.apache.maven.archetypes.classes.AbstractModel;

import java.util.List;

public interface BinarySearchInterface<T extends AbstractModel<T>> {
    int binarySearch(List<T> models, T target);
}
