package com.lucio.algo.structure.tree;

import com.lucio.algo.structure.list.ArrayList;

import java.util.Iterator;

public class BinaryMinHeap<T extends Comparable<T>> implements Iterable<T> {
    private final ArrayList<T> values;

    public BinaryMinHeap() {
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

    private T getParentValue(int index) {
        int parentIndex = this.getParentIndex(index);
        return this.values.get(parentIndex);
    }

    private T getLeftChildValue(int index) {
        int childIndex = this.getLeftChildIndex(index);
        return this.values.get(childIndex);
    }

    private T getRightChildValue(int index) {
        int childIndex = this.getRightChildIndex(index);
        return this.values.get(childIndex);
    }

    @Override
    public Iterator<T> iterator() {
        return this.values.iterator();
    }
}
