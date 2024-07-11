package com.lucio.algo.structure.tree;

import com.lucio.algo.structure.list.ArrayList;

import java.util.Iterator;

public class BinaryMaxHeap<T extends Comparable<T>> implements Iterable<T> {
    private final ArrayList<T> values;

    public BinaryMaxHeap() {
        this.values = new ArrayList<>();
    }

    public int getSize() {
        return this.values.getSize();
    }

    @Override
    public Iterator<T> iterator() {
        return this.values.iterator();
    }
}