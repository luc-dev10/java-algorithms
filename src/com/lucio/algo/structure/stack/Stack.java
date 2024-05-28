package com.lucio.algo.structure.stack;

import com.lucio.algo.structure.list.DoublyList;
import com.lucio.algo.structure.node.Node;

// LIFO = Last Element Added to Stack is the First Element Removed
public class Stack<E> {

    private final DoublyList<E> doublyList = new DoublyList<>();

    // pop - O(1)
    public E pop() {
        return doublyList.pop();
    }

    // push O(1)
    public void push(E value) {
        doublyList.push(value);
    }

    // size O(1)
    public int size() {
        return doublyList.getSize();
    }

    // get by index - O(n)
    public E get(int index) {
        Node<E> node = doublyList.get(index);
        return node != null ? node.getValue() : null;
    }

    // set by index - O(n)
    public void set(int index, E value) {
        doublyList.set(index, value);
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        for (E value : doublyList)
            stringBuilder.append(value)
                    .append("\n");

        return stringBuilder.toString();
    }
}
