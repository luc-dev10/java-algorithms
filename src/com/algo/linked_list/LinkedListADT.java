package com.algo.linked_list;

public interface LinkedListADT<E> {

    void push(E value);

    void pop(E value);

    int getSize();

    E getFirstValue();

    E getLastValue();

}