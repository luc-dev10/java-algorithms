package com.lucio.algo.structure.list;

import java.util.Iterator;

@SuppressWarnings("unchecked cast")
public class ArrayList<T extends Comparable<T>> implements Iterable<T> {
    private int size;
    private Object[] values;

    public ArrayList() {
        int INITIAL_CAPACITY = 5;
        values = new Object[INITIAL_CAPACITY];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return (T) values[index++];
            }
        };
    }
}
