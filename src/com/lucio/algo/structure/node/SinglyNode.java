package com.lucio.algo.structure.node;

public class SinglyNode<E> {

    private E value;
    private SinglyNode<E> nextNode;

    public SinglyNode(E value) {
        this.value = value;
        this.nextNode = null;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public SinglyNode<E> getNextNode() {
        return nextNode;
    }

    public void setNextNode(SinglyNode<E> next) {
        this.nextNode = next;
    }
}
