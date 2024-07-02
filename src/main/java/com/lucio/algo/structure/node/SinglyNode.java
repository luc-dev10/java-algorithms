package com.lucio.algo.structure.node;

public class SinglyNode<T> {
    private T value;
    private SinglyNode<T> nextNode;

    public SinglyNode(T value) {
        this.value = value;
        this.nextNode = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public SinglyNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(SinglyNode<T> next) {
        this.nextNode = next;
    }
}
