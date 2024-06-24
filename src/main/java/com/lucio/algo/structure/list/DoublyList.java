package com.lucio.algo.structure.list;

import com.lucio.algo.structure.adt.ListADT;
import com.lucio.algo.structure.node.DoublyNode;

import java.util.Iterator;

public class DoublyList<E> implements ListADT<E>, Iterable<E> {
    // props
    private DoublyNode<E> head;
    private DoublyNode<E> tail;
    private int size;

    // constructor
    public DoublyList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // push
    public void push(E value) {
        DoublyNode<E> node = new DoublyNode<E>(value);
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

    @Override
    public void insertOnIndex(int index, E newValue) {

    }

    @Override
    public void removeAt(int index) {

    }

    // pop last item
    public E pop() {

        // do nothing if size = 0
        if (this.size == 0) return null;

        E value = this.tail.getValue();
        if (size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            DoublyNode<E> tempNode = this.tail.getPreviousNode();
            tempNode.setNextNode(null);
            this.tail.setPreviousNode(null);
            this.tail = tempNode;
        }

        this.size--;
        return value;
    }

    // shift
    public E shift() {
        if (this.size == 0) return null;

        DoublyNode<E> temp = this.head;
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            DoublyNode<E> currentNode = this.head.getNextNode();
            head.setNextNode(null);
            currentNode.setPreviousNode(null);
            this.head = currentNode;
        }
        this.size--;

        return temp.getValue();
    }

    // unshift
    public void unshift(E value) {
        DoublyNode<E> node = new DoublyNode<E>(value);
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

    public DoublyNode<E> get(int index) {
        if (index >= size || index < 0) return null;

        DoublyNode<E> current = null;
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
        if (index >= size || index < 0) return false;

        DoublyNode<E> current = this.head;
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

        if (this.size < index || index < 0) return false;

        if (this.size == 0 || this.size == 1 || this.size == index) {
            this.push(value);
            return true;
        } else if (index == 0) {
            this.unshift(value);
            return true;
        } else {

            DoublyNode<E> newNode = new DoublyNode<>(value);
            DoublyNode<E> previousNode = this.get(index - 1);
            DoublyNode<E> nextNode = previousNode.getNextNode();

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

            DoublyNode<E> currentNode = this.get(index);
            DoublyNode<E> previousNode = currentNode.getPreviousNode();
            DoublyNode<E> nextNode = currentNode.getNextNode();

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

    public void reverse() {
        if (this.size <= 1) return;

        // reverse head tail
        DoublyNode<E> temp = this.tail;
        this.tail = this.head;
        this.head = temp;

        while (temp != null) {

            DoublyNode<E> previousNode = temp.getPreviousNode();
            DoublyNode<E> nextNode = temp.getNextNode();
            temp.setPreviousNode(nextNode);
            temp.setNextNode(previousNode);

            temp = temp.getNextNode();

        }

    }

    public int getSize() {
        return this.size;
    }

    public E getFirstValue() {
        return this.head != null ? this.head.getValue() : null;
    }

    public E getLastValue() {
        return this.tail != null ? this.tail.getValue() : null;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            DoublyNode<E> current = head;

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
        };
    }
}