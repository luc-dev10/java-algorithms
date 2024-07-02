package com.lucio.algo.structure.list;

import com.lucio.algo.structure.adt.ListADT;
import com.lucio.algo.structure.node.SinglyNode;

import java.util.Iterator;

public class SinglyList<T> implements ListADT<T>, Iterable<T> {
    private int size;
    private SinglyNode<T> head;
    private SinglyNode<T> tail;

    public SinglyList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // O(n)
    public SinglyNode<T> get(int index) {
        // index higher than size
        if (index >= size || index < 0) throw new IndexOutOfBoundsException("Index out of bounds.");

        int counter = 0;
        SinglyNode<T> current = this.head;
        while (current != null) {
            if (counter == index) return current;
            counter++;
            current = current.getNextNode();
        }

        // value not found
        return null;
    }

    @Override
    public T getFirstValue() {
        return head.getValue();
    }

    @Override
    public T getLastValue() {
        return tail.getValue();
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {return this.size == 0;}

    // O(1) constant time
    @Override
    public void push(T value) {
        SinglyNode<T> node = new SinglyNode<>(value);
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
    public void insertOnIndex(int index, T value) {
        if (index < 0 || index > this.size) throw new IndexOutOfBoundsException("Index out of bounds.");

        if (index == 0) {
            this.unshift(value);
            return;
        }

        if (this.size == index) {
            this.push(value);
            return;
        }

        // Get previous
        SinglyNode<T> previous = this.get(index - 1);
        SinglyNode<T> next = previous.getNextNode();
        SinglyNode<T> node = new SinglyNode<>(value);
        previous.setNextNode(node);
        node.setNextNode(next);
        this.size++;
    }

    @Override
    public void set(int index, T value) {
        SinglyNode<T> currentNode = this.get(index);
        currentNode.setValue(value);
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
        SinglyNode<T> previous = this.get(index - 1);
        SinglyNode<T> current = previous.getNextNode();
        previous.setNextNode(current.getNextNode());
        current.setNextNode(null);
        this.size--;
    }

    // O(n)
    @Override
    public T pop() {
        // if size is 0
        if (this.tail == null) return null;

        // _____________________________________

        // Get Last value of return
        T value = this.tail.getValue();

        // _____________________________________

        // find second last item
        SinglyNode<T> currentNode = this.head;
        SinglyNode<T> newTail = currentNode;

        while (currentNode.getNextNode() != null) {
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
    public T shift() {
        if (size == 0) {
            return null;
        }

        T value = head.getValue();
        if (size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            SinglyNode<T> tempNode = this.head.getNextNode();
            this.head.setNextNode(null);
            this.head = tempNode;
        }

        size--;
        return value;
    }

    // O(1)
    @Override
    public void unshift(T value) {
        SinglyNode<T> newNode = new SinglyNode<>(value);
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
        SinglyNode<T> currentNode = this.head;

        // head = tail, tail = head
        this.head = this.tail;
        this.tail = currentNode;

        SinglyNode<T> nextNode;
        SinglyNode<T> previousNode = null;

        while (currentNode != null) {
            nextNode = currentNode.getNextNode();
            currentNode.setNextNode(previousNode);
            previousNode = currentNode;
            currentNode = nextNode;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            SinglyNode<T> current = head;

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