package com.lucio.algo.structure.node;

public class Node<E> {

    private E value;
    private Node<E> nextNode;
    private Node<E> previousNode;

    public Node(E value) {
        this.value = value;
        this.nextNode = null;
        this.previousNode = null;
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

    public Node<E> getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node<E> previousNode) {
        this.previousNode = previousNode;
    }
}
