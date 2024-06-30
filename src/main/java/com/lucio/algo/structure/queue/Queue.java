package com.lucio.algo.structure.queue;

import com.lucio.algo.structure.list.DoublyList;

// FIFO
public class Queue<E> {
    DoublyList<E> doublyList = new DoublyList<>();

    // O(1)
    public void enqueue(E value) {
        this.doublyList.push(value);
    }

    // O(1)
    public E dequeue() {
        return this.doublyList.shift();
    }

    // O(1)
    public E peek() {
        return this.doublyList.getFirstValue();
    }

    // O(1)
    public int getSize() {
        return this.doublyList.getSize();
    }

    // O(1)
    public boolean isEmpty() {
        return this.doublyList.getSize() == 0;
    }
}
