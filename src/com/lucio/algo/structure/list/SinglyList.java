package com.lucio.algo.structure.list;

import com.lucio.algo.structure.node.SinglyNode;

import java.util.Iterator;

public class SinglyList<E> implements LinkedListADT<E>, Iterable<E> {
    private int size;
    private SinglyNode<E> head;
    private SinglyNode<E> tail;

    public SinglyList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // iterator method
    protected SinglyNode<E> getHead() {
        return this.head;
    }

    protected SinglyNode<E> getTail() {
        return this.tail;
    }

    // O(1) constant time
    @Override
    public void push(E value) {
        SinglyNode<E> node = new SinglyNode<>(value);
        if (this.head == null) {
            this.head = node;
            this.tail = this.head;
        } else {
            this.tail.setNextNode(node);
            this.tail = node;
        }
        size++;
    }

    // O(n)
    @Override
    public E pop() {
        // if size is 0
        if (this.tail == null) return null;

        // _____________________________________

        // Get Last value of return
        E value = this.tail.getValue();

        // _____________________________________

        // find second last item
        SinglyNode<E> currentNode = this.head;
        SinglyNode<E> newTail = currentNode;

        while (currentNode != null) {
            newTail = currentNode;
            currentNode = currentNode.getNextNode();
        }

        // _____________________________________

        this.tail = newTail;
        this.tail.setNextNode(null);
        this.size--;
        if (this.size == 1) this.head = this.tail;

        return value;
    }

    // O(1)
    public E shift() {
        if (size == 0) {
            return null;
        }

        E value = head.getValue();
        if (size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            SinglyNode<E> tempNode = this.head.getNextNode();
            this.head.setNextNode(null);
            this.head = tempNode;
        }

        size--;
        return value;
    }

    // O(1)
    public void unshift(E value) {

        SinglyNode<E> newNode = new SinglyNode<>(value);
        if (size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.setNextNode(this.head);
            this.head = newNode;
        }

        size++;
    }

    // reverse
    public void reverse() {

        if (this.size <= 1) return;

        // keep copy for loop & assignment
        SinglyNode<E> currentNode = this.head;

        // head = tail, tail = head
        this.head = this.tail;
        this.tail = currentNode;

        SinglyNode<E> nextNode;
        SinglyNode<E> previousNode = null;

        while (currentNode != null) {
            nextNode = currentNode.getNextNode();
            currentNode.setNextNode(previousNode);
            previousNode = currentNode;
            currentNode = nextNode;
        }

    }

    // O(n)
    public E get(int index) {
        // index higher than size
        if (index >= size) throw new IndexOutOfBoundsException("Index out of bounds.");

        int counter = 0;
        for (E value : this) {
            if (counter == index) return value;
            counter++;
        }

        // value not found
        return null;
    }

    // set on index
    public boolean set(int index, E newValue) {
        SinglyNode<E> currentNode = this.head;

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
        if (index < 0 || index >= this.size) return false;

        // loop
        SinglyNode<E> currentNode = this.head;
        SinglyNode<E> nextNode = currentNode.getNextNode();

        int counter = 0;
        while (currentNode != null) {
            if (counter == index) {
                SinglyNode<E> newNode = new SinglyNode<>(newValue);
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
    SinglyNode<E> current;

    public LinkedListIterator(SinglyList<E> singlyList) {
        current = singlyList.getHead();
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