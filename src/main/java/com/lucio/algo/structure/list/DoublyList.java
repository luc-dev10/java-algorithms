package com.lucio.algo.structure.list;

import com.lucio.algo.structure.adt.ListADT;
import com.lucio.algo.structure.node.DoublyNode;

import java.util.Iterator;

public class DoublyList<T> implements ListADT<T>, Iterable<T> {
    // props
    private DoublyNode<T> head;
    private DoublyNode<T> tail;
    private int size;

    // constructor
    public DoublyList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // O(n)
    public DoublyNode<T> get(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();

        DoublyNode<T> current = this.head;
        int count = 0;
        while (current != null) {
            if (count == index) break;
            current = current.getNextNode();
            count++;
        }

        return current;
    }

    @Override
    public T getFirstValue() {
        return this.head != null ? this.head.getValue() : null;
    }

    @Override
    public T getLastValue() {
        return this.tail != null ? this.tail.getValue() : null;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {return this.size == 0;}

    // O(1)
    @Override
    public void push(T value) {
        DoublyNode<T> node = new DoublyNode<>(value);
        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.setNextNode(node);
            node.setPreviousNode(this.tail);
        }

        this.tail = node;
        this.size++;
    }

    // O(1)
    @Override
    public void insertOnIndex(int index, T value) {
        if (this.size < index || index < 0) throw new IndexOutOfBoundsException();

        if (this.size == 0 || this.size == 1 || this.size == index) {
            this.push(value);
        } else if (index == 0) {
            this.unshift(value);
        } else {
            DoublyNode<T> newNode = new DoublyNode<>(value);
            DoublyNode<T> previousNode = this.get(index - 1);
            DoublyNode<T> nextNode = previousNode.getNextNode();

            previousNode.setNextNode(newNode);
            nextNode.setPreviousNode(newNode);
            newNode.setPreviousNode(previousNode);
            newNode.setNextNode(nextNode);
            this.size++;
        }
    }

    // O(1)
    @Override
    public void removeAt(int index) {
        if (index < 0 || index >= this.size) throw new IndexOutOfBoundsException();

        if (index == 0) {
            this.shift();
            return;
        }
        if (index == this.size - 1) {
            this.pop();
            return;
        }

        DoublyNode<T> currentNode = this.get(index);
        DoublyNode<T> previousNode = currentNode.getPreviousNode();
        DoublyNode<T> nextNode = currentNode.getNextNode();

        previousNode.setNextNode(nextNode);
        nextNode.setPreviousNode(previousNode);
        currentNode.setNextNode(null);
        currentNode.setPreviousNode(null);

        this.size--;
    }

    // O(n)
    public void set(int index, T value) {
        DoublyNode<T> currentNode = this.get(index);
        currentNode.setValue(value);
    }

    // O(1)
    @Override
    public T pop() {
        if (this.size == 0) return null;

        T value = this.tail.getValue();
        if (size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            DoublyNode<T> tempNode = this.tail.getPreviousNode();
            tempNode.setNextNode(null);
            this.tail.setPreviousNode(null);
            this.tail = tempNode;
        }

        this.size--;
        return value;
    }

    // O(1)
    @Override
    public T shift() {
        if (this.size == 0) return null;

        DoublyNode<T> temp = this.head;
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            DoublyNode<T> currentNode = this.head.getNextNode();
            head.setNextNode(null);
            currentNode.setPreviousNode(null);
            this.head = currentNode;
        }
        this.size--;
        return temp.getValue();
    }

    // O(1)
    @Override
    public void unshift(T value) {
        DoublyNode<T> node = new DoublyNode<>(value);
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

    @Override
    public void reverse() {
        if (this.size <= 1) return;

        // reverse head tail
        DoublyNode<T> temp = this.tail;
        this.tail = this.head;
        this.head = temp;

        while (temp != null) {
            DoublyNode<T> previousNode = temp.getPreviousNode();
            DoublyNode<T> nextNode = temp.getNextNode();
            temp.setPreviousNode(nextNode);
            temp.setNextNode(previousNode);

            temp = temp.getNextNode();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            DoublyNode<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T value = current.getValue();
                current = current.getNextNode();
                return value;
            }
        };
    }
}