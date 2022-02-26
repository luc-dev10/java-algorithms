package com.algo.linked_list;

public class Node<E> {

    private E value;
    private Node<E> nextNode;

    public Node(E value) {
        this.value = value;
        this.nextNode = null;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node<E> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<E> next) {
        this.nextNode = next;
    }
}
