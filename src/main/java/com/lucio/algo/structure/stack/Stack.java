package com.lucio.algo.structure.stack;

import com.lucio.algo.structure.list.DoublyList;

// LIFO
public class Stack<E> {
    private final DoublyList<E> doublyList = new DoublyList<>();

    // pop - O(1)
    public E pop() {
        return this.doublyList.pop();
    }

    // push O(1)
    public void push(E value) {
        this.doublyList.push(value);
    }

    // peek
    public E peek() {
        return this.doublyList.getLastValue();
    }

    // size O(1)
    public int getSize() {
        return this.doublyList.getSize();
    }

    // O(1)
    public boolean isEmpty() {
        return this.doublyList.isEmpty();
    }
}
