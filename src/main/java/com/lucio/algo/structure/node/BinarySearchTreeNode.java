package com.lucio.algo.structure.node;

public class BinarySearchTreeNode<T> {
    private T value;
    private BinarySearchTreeNode<T> left;
    private BinarySearchTreeNode<T> right;

    public BinarySearchTreeNode() {
        this.left = new BinarySearchTreeNode<>();
        this.right = new BinarySearchTreeNode<>();
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BinarySearchTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinarySearchTreeNode<T> left) {
        this.left = left;
    }

    public BinarySearchTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinarySearchTreeNode<T> right) {
        this.right = right;
    }
}
