package com.algo.doubly_list;

import com.algo.linked_list.LinkedListADT;

import java.util.Iterator;

public class DoublyList<E> implements LinkedListADT<E>, Iterable<E> {

    // props
    private Node<E> head;
    private Node<E> tail;
    private int size;

    // constructor
    public DoublyList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // protected for iterator
    protected Node<E> getHead() {
        return this.head;
    }

    // push
    @Override
    public void push(E value) {

        Node<E> node = new Node<E>(value);
        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.setNextNode(node);
            node.setPreviousNode(this.tail);
        }

        // update tail
        this.tail = node;

        // increase size
        this.size++;

    }

    // pop last item
    @Override
    public void pop() {

    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public E getFirstValue() {
        return null;
    }

    @Override
    public E getLastValue() {
        return null;
    }

    @Override
    public void reverse() {

    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator<E>(this);
    }

    // iterator
    static class LinkedListIterator<E> implements Iterator<E> {

        // current value
        Node<E> current;

        public LinkedListIterator(DoublyList<E> doublyList) {
            current = doublyList.getHead();
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E value = current.getValue();
            current = current.getNextNode();
            return value;
        }
    }

}

