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

        if (this.size == 1) {
            this.head = null;
            this.tail = null;
            this.size--;
        } else if (this.size > 1) {
            Node<E> tempNode = this.tail.getPreviousNode();
            this.tail.setPreviousNode(null);
            tempNode.setNextNode(null);
            this.tail = tempNode;
            this.size--;
        }

    }

    // shift
    public void shift() {

        if (this.size == 0)
            return;

        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            Node<E> temp = this.head.getNextNode();
            head.setNextNode(null);
            temp.setPreviousNode(null);
            this.head = temp;
        }
        this.size--;
    }

    @Override
    public void reverse() {

    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public E getFirstValue() {
        return this.head != null ? this.head.getValue() : null;
    }

    @Override
    public E getLastValue() {
        return this.tail != null ? this.tail.getValue() : null;
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

