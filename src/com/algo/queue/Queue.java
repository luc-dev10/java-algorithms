package com.algo.queue;

import com.algo.doubly_list.DoublyList;
import com.algo.doubly_list.Node;

// FIFO
public class Queue<E> {

    DoublyList<E> doublyList = new DoublyList<E>();

    // push
    public void push(E value) {
        doublyList.push(value);
    }

    // pop
    public E pop() {

        Node<E> shiftNode = doublyList.shift();

        return shiftNode != null ? shiftNode
                .getValue() : null;
    }

    // size
    public int size() {
        return doublyList.getSize();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (E value : doublyList)
            stringBuilder.append("Item: ")
                         .append(value)
                         .append("\n");
        return stringBuilder.toString();
    }

}
