package com.lucio.algo.structure.node;

public class BinarySearchTreeNode<T> {
    private T value;
    private BinarySearchTreeNode<T> left;
    private BinarySearchTreeNode<T> right;

    public BinarySearchTreeNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BinarySearchTreeNode<T> getLeft() {
        return this.left;
    }

    public void setLeft(BinarySearchTreeNode<T> left) {
        this.left = left;
    }

    public BinarySearchTreeNode<T> getRight() {
        return this.right;
    }

    public void setRight(BinarySearchTreeNode<T> right) {
        this.right = right;
    }
}
