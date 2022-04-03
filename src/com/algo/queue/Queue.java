package com.algo.queue;

import com.algo.doubly_list.DoublyList;

// FIFO
public class Queue<E> {

    DoublyList<E> doublyList = new DoublyList<E>();

    // push
    public void push(E value) {
        doublyList.push(value);
    }

    // size
    public int size() {
        return doublyList.getSize();
    }

}
