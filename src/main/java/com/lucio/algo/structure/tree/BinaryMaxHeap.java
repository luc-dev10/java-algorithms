package com.lucio.algo.structure.tree;

import com.lucio.algo.structure.list.ArrayList;

import java.util.Iterator;

public class BinaryMaxHeap<T extends Comparable<T>> implements Iterable<T> {
    private final ArrayList<T> values;

    public BinaryMaxHeap() {
        this.values = new ArrayList<>();
    }

    // get parent index (n - 1)/2
    private int getParentIndex(int index) {return (index - 1) / 2;}

    // left child index 2n + 1
    private int getLeftChildIndex(int index) {return 2 * index + 1;}

    // right child 2n + 2
    private int getRightChildIndex(int index) {return (2 * index) + 2;}

    private boolean hasParent(int index) {return this.getParentIndex(index) >= 0;}

    private boolean hasLeftChild(int index) {return this.getLeftChildIndex(index) < this.values.getSize();}

    private boolean hasRightChild(int index) {return this.getRightChildIndex(index) < this.values.getSize();}

    public int getSize() {
        return this.values.getSize();
    }

    public boolean isEmpty() {
        return this.values.isEmpty();
    }

    // O(1)
    public T peek() {
        return this.values.get(0);
    }

    @Override
    public Iterator<T> iterator() {
        return this.values.iterator();
    }
}