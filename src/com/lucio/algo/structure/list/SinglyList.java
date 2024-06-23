package com.lucio.algo.structure.list;

import com.lucio.algo.structure.adt.ListADT;
import com.lucio.algo.structure.node.Node;

import java.util.Iterator;

public class SinglyList<E> implements ListADT<E>, Iterable<E> {
    private int size;
    private Node<E> head;
    private Node<E> tail;

    public SinglyList() {
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

    // O(n)
    public Node<E> get(int index) {
        // index higher than size
        if (index >= size) throw new IndexOutOfBoundsException("Index out of bounds.");

        int counter = 0;
        Node<E> current = this.head;
        while (current != null) {
            if (counter == index) return current;
            counter++;
            current = current.getNextNode();
        }

        // value not found
        return null;
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
    public int getSize() {
        return this.size;
    }

    // O(1) constant time
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

    // insert on index - O(n)
    @Override
    public void insertOnIndex(int index, E newValue) {
        if (index < 0 || index > this.size) throw new IndexOutOfBoundsException("Index out of bounds.");

        if (index == 0) {
            this.unshift(newValue);
            return;
        }

        if (this.size == index) {
            this.push(newValue);
            return;
        }

        // Get previous
        Node<E> previous = this.get(index - 1);
        Node<E> next = previous.getNextNode();
        Node<E> node = new Node<>(newValue);
        previous.setNextNode(node);
        node.setNextNode(next);
        this.size++;
    }

    // remove at index - O(n)
    @Override
    public void removeAt(int index) {
        if (index < 0 || index > this.size) throw new IndexOutOfBoundsException("Index out of bounds.");

        if (index == 0) {
            this.shift();
            return;
        }

        if (this.size == index) {
            this.pop();
            return;
        }

        // Get previous
        Node<E> previous = this.get(index - 1);
        Node<E> current = previous.getNextNode();
        previous.setNextNode(current.getNextNode());
        current.setNextNode(null);
        this.size--;
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
        Node<E> currentNode = this.head;
        Node<E> newTail = currentNode;

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
    @Override
    public E shift() {
        if (size == 0) {
            return null;
        }

        E value = head.getValue();
        if (size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            Node<E> tempNode = this.head.getNextNode();
            this.head.setNextNode(null);
            this.head = tempNode;
        }

        size--;
        return value;
    }

    // O(1)
    @Override
    public void unshift(E value) {

        Node<E> newNode = new Node<>(value);
        if (size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.setNextNode(this.head);
            this.head = newNode;
        }

        size++;
    }

    // reverse - O(n)
    @Override
    public void reverse() {
        if (this.size <= 1) return;

        // keep copy for loop & assignment
        Node<E> currentNode = this.head;

        // head = tail, tail = head
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

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator<>(this);
    }
}

// iterator
class LinkedListIterator<E> implements Iterator<E> {

    // current value
    Node<E> current;

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