package com.lucio.algo.structure.adt;

public interface ListADT<T> {
    T getFirstValue();

    T getLastValue();

    int getSize();

    boolean isEmpty();

    void push(T value);

    void insertOnIndex(int index, T value);

    void set(int index, T value);

    void removeAt(int index);

    T pop();

    T shift();

    void unshift(T value);

    void reverse();
}
