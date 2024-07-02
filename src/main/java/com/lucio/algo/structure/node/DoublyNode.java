package com.lucio.algo.structure.node;

public class DoublyNode<T> {
    private T value;
    private DoublyNode<T> nextNode;
    private DoublyNode<T> previousNode;

    public DoublyNode(T value) {
        this.value = value;
        this.nextNode = null;
        this.previousNode = null;
    }

    public DoublyNode<T> getPreviousNode() {
        return this.previousNode;
    }

    public void setPreviousNode(DoublyNode<T> previousNode) {
        this.previousNode = previousNode;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public DoublyNode<T> getNextNode() {
        return this.nextNode;
    }

    public void setNextNode(DoublyNode<T> nextNode) {
        this.nextNode = nextNode;
    }
}
