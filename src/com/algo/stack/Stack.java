package com.algo.stack;

import com.algo.singly_list.SinglyList;

// LIFO = Last Element Added to Stack is the First Element Removed
public class Stack<E> {

    private final SinglyList<E> singlyList = new SinglyList<>();

    // pop - O(1)
    public E pop() {
        return singlyList.shift();
    }

    // push O(1)
    public void push(E value) {
        singlyList.unshift(value);
    }

    // size O(1)
    public int size() {
        return singlyList.getSize();
    }

    // get by index - O(n)
    public E get(int index) {
        return singlyList.get(index);
    }

    // set by index - O(n)
    public void set(int index, E value) {
        singlyList.set(index, value);
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
