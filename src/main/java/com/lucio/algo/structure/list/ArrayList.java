package com.lucio.algo.structure.list;

@SuppressWarnings("unchecked cast")
public class ArrayList<T extends Comparable<T>> {
    private int size;
    private Object[] values;

    public ArrayList() {
        int INITIAL_CAPACITY = 5;
        values = new Object[INITIAL_CAPACITY];
    }
}
