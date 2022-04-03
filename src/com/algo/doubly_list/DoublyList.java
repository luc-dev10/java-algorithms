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

        // do nothing if size = 0
        if (this.size == 0)
            return;

        if (size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            Node<E> tempNode = this.tail.getPreviousNode();
            this.tail.setPreviousNode(null);
            tempNode.setNextNode(null);
            this.tail = tempNode;
        }

        this.size--;

    }

    // shift
    public Node<E> shift() {

        if (this.size == 0)
            return null;

        Node<E> temp = this.head.getNextNode();
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            head.setNextNode(null);
            temp.setPreviousNode(null);
            this.head = temp;
        }
        this.size--;

        return temp;
    }

    // unshift
    public void unshift(E value) {
        Node<E> node = new Node<E>(value);
        if (this.size == 0) {
            this.head = node;
            this.tail = node;
        } else {
            this.head.setPreviousNode(node);
            node.setNextNode(this.head);
            this.head = node;
        }
        this.size++;
    }

    public Node<E> get(int index) {
        if (index >= size || index < 0)
            return null;

        Node<E> current = null;
        if (index > (this.size / 2)) {
            current = this.tail;
            int count = this.size - 1;
            while (count != index) {
                current = current.getPreviousNode();
                count--;
            }

        } else {
            current = this.head;
            int count = 0;
            while (count != index) {
                current = current.getNextNode();
                count++;
            }
        }

        return current;
    }

    public boolean set(int index, E value) {
        if (index >= size || index < 0)
            return false;

        Node<E> current = this.head;
        int count = 0;
        while (current != null) {

            if (index == count) {
                current.setValue(value);
                return true;
            }
            // update index
            count++;
            current = current.getNextNode();
        }

        return false;
    }

    // insert
    public boolean insert(int index, E value) {

        if (this.size < index || index < 0)
            return false;

        if (this.size == 0 || this.size == 1 || this.size == index) {
            this.push(value);
            return true;
        } else if (index == 0) {
            this.unshift(value);
            return true;
        } else {

            Node<E> newNode = new Node<>(value);
            Node<E> previousNode = this.get(index - 1);
            Node<E> nextNode = previousNode.getNextNode();

            previousNode.setNextNode(newNode);
            nextNode.setPreviousNode(newNode);
            newNode.setPreviousNode(previousNode);
            newNode.setNextNode(nextNode);
            this.size++;
            return true;
        }

    }

    public boolean remove(int index) {
        if (this.size < index || index < 0) {
            return false;
        } else if (index == 0) {
            this.shift();
            return true;
        } else if (index == this.size - 1) {
            this.pop();
            return true;
        } else {

            Node<E> currentNode = this.get(index);
            Node<E> previousNode = currentNode.getPreviousNode();
            Node<E> nextNode = currentNode.getNextNode();

            // empty values
            currentNode.setNextNode(null);
            currentNode.setPreviousNode(null);

            // patch
            previousNode.setNextNode(nextNode);
            nextNode.setPreviousNode(previousNode);

            // update size
            size--;

            return true;
        }

    }

    @Override
    public void reverse() {
        if (this.size <= 1)
            return;

        // reverse head tail
        Node<E> temp = this.tail;
        this.tail = this.head;
        this.head = temp;

        while (temp != null) {

            Node<E> previousNode = temp.getPreviousNode();
            Node<E> nextNode = temp.getNextNode();
            temp.setPreviousNode(nextNode);
            temp.setNextNode(previousNode);

            temp = temp.getNextNode();

        }

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

