package com.lucio.algo.structure.queue;

import com.lucio.algo.structure.list.DoublyList;

// FIFO
public class Queue<T> {
    DoublyList<T> doublyList = new DoublyList<>();

    // O(1)
    public void enqueue(T value) {
        this.doublyList.push(value);
    }

    // O(1)
    public T dequeue() {
        return this.doublyList.shift();
    }

    // O(1)
    public T peek() {
        return this.doublyList.getFirstValue();
    }

    // O(1)
    public int getSize() {
        return this.doublyList.getSize();
    }

    // O(1)
    public boolean isEmpty() {
        return this.doublyList.isEmpty();
    }
}
