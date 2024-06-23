package com.lucio.algo.structure.node;

public class DoublyNode<E> {
    private E value;
    private DoublyNode<E> nextNode;
    private DoublyNode<E> previousNode;

    public DoublyNode(E value) {
        this.value = value;
        this.nextNode = null;
        this.previousNode = null;
    }

    public DoublyNode<E> getPreviousNode() {
        return this.previousNode;
    }

    public void setPreviousNode(DoublyNode<E> previousNode) {
        this.previousNode = previousNode;
    }

    public E getValue() {
        return this.value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public DoublyNode<E> getNextNode() {
        return this.nextNode;
    }

    public void setNextNode(DoublyNode<E> nextNode) {
        this.nextNode = nextNode;
    }
}
