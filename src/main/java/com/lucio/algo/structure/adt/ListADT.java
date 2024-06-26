package com.lucio.algo.structure.adt;

public interface ListADT<E> {
    E getFirstValue();

    E getLastValue();

    int getSize();

    boolean isEmpty();

    void push(E value);

    void insertOnIndex(int index, E newValue);

    void set(int index, E newValue);

    void removeAt(int index);

    E pop();

    E shift();

    void unshift(E value);

    void reverse();
}
