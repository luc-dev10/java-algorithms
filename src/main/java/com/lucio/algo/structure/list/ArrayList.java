package com.lucio.algo.structure.list;

import java.util.Arrays;
import java.util.Iterator;

@SuppressWarnings("unchecked cast")
public class ArrayList<T extends Comparable<T>> implements Iterable<T> {
    private int size;
    private Object[] values;

    public ArrayList() {
        int INITIAL_CAPACITY = 5;
        values = new Object[INITIAL_CAPACITY];
    }

    private void ensureCapacity() {
        if (this.size == values.length) values = Arrays.copyOf(values, values.length * 2);
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void add(T value) {
        this.ensureCapacity();
        values[size++] = value;
    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return (T) values[index];
    }

    public void set(int index, T value) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        values[index] = value;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        T value = (T) values[index];
        int shiftElements = size - index - 1;

        if (shiftElements > 0) {
            System.arraycopy(this.values, index + 1, this.values, index, shiftElements);
        }

        this.values[--size] = null;
        return value;
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
