package com.lucio.algo.structure.stack;

import com.lucio.algo.structure.list.DoublyList;

// LIFO
public class Stack<T> {
    private final DoublyList<T> doublyList = new DoublyList<>();

    // pop - O(1)
    public T pop() {
        return this.doublyList.pop();
    }

    // push O(1)
    public void push(T value) {
        this.doublyList.push(value);
    }

    // peek
    public T peek() {
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
