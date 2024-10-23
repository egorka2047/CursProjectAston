package org.apache.maven.archetypes.classes;

public abstract class AbstractModel<T> implements Comparable<T>{
    @Override
    public int compareTo(T o) {
        return 0;
    }
}