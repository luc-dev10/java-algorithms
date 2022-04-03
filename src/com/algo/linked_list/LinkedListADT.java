package com.algo.linked_list;

public interface LinkedListADT<E> {

    void push(E value);

    E pop();

    int getSize();

    E getFirstValue();

    E getLastValue();

    void reverse();
}
