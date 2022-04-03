package com.algo.stack;

import com.algo.singly_list.SinglyList;

// LIFO = Last Element Added to Stack is the First Element Removed
public class Stack<E> {

    private final SinglyList<E> singlyList = new SinglyList<>();

    // pop
    public E pop() {
        return singlyList.shift();
    }

    // push
    public void push(E value) {
        singlyList.unshift(value);
    }

    // size
    public int size() {
        return singlyList.getSize();
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        for (E value : singlyList)
            stringBuilder.append(value)
                         .append("\n");

        return stringBuilder.toString();
    }
}
