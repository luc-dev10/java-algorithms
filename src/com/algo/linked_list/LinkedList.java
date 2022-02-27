package com.algo.linked_list;

import java.util.Iterator;

public class LinkedList<E> implements LinkedListADT<E>, Iterable<E> {

    private int size;
    private Node<E> head;
    private Node<E> tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // iterator method
    protected Node<E> getHead() {
        return this.head;
    }

    protected Node<E> getTail() {
        return this.tail;
    }

    @Override
    public void push(E value) {

        Node<E> node = new Node<>(value);
        if (this.head == null) {
            this.head = node;
            this.tail = this.head;
        } else {
            this.tail.setNextNode(node);
            this.tail = node;
        }
        size++;
    }

    @Override
    public void pop() {

        Node<E> currentNode = this.head;
        Node<E> previousNode = null;

        while (currentNode != null) {

            if (currentNode == tail) {
                if (currentNode == head) {
                    head = null;
                    tail = null;
                } else {
                    Node<E> temp = currentNode.getNextNode();
                    previousNode.setNextNode(temp);
                    tail = previousNode;
                }
                size--;
                break;
            }

            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }

    }

    // reverse
    public void reverse() {

        if (this.size <= 1)
            return;

        Node<E> currentNode = this.head;
        this.head = this.tail;
        this.tail = currentNode;

        Node<E> nextNode;
        Node<E> previousNode = null;

        while (currentNode != null) {
            nextNode = currentNode.getNextNode();
            currentNode.setNextNode(previousNode);
            previousNode = currentNode;
            currentNode = nextNode;
        }

    }

    // get by index
    public E get(int index) {

        if (index >= size)
            return null;

        int counter = 0;
        for (E value : this) {
            if (counter == index)
                return value;

            counter++;
        }

        // value not found
        return null;
    }

    // set on index
    public boolean set(int index, E newValue) {
        Node<E> currentNode = this.head;

        int counter = 0;
        while (currentNode != null) {
            if (counter == index) {
                currentNode.setValue(newValue);
                return true;
            }
            counter++;
            currentNode = currentNode.getNextNode();
        }
        return false;
    }

    // insert on index
    public boolean insertOnIndex(int index, E newValue) {
        if (index < 0 || index >= this.size)
            return false;

        // loop
        Node<E> currentNode = this.head;
        Node<E> nextNode = currentNode.getNextNode();

        int counter = 0;
        while (currentNode != null) {
            if (counter == index) {
                Node<E> newNode = new Node<>(newValue);
                currentNode.setNextNode(newNode);
                newNode.setNextNode(nextNode);
                return true;
            }
            counter++;
            currentNode = currentNode.getNextNode();
            nextNode = currentNode != null ? currentNode.getNextNode() : null;
        }

        return false;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public E getFirstValue() {
        return head.getValue();
    }

    @Override
    public E getLastValue() {
        return tail.getValue();
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator<>(this);
    }
}

// iterator
class LinkedListIterator<E> implements Iterator<E> {

    // current value
    Node<E> current;

    public LinkedListIterator(LinkedList<E> linkedList) {
        current = linkedList.getHead();
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