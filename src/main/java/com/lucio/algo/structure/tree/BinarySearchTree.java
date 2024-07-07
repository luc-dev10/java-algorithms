package com.lucio.algo.structure.tree;

import com.lucio.algo.structure.node.BinarySearchTreeNode;

public class BinarySearchTree<T extends Comparable<T>> {
    private BinarySearchTreeNode<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public BinarySearchTreeNode<T> getRoot() {
        return this.root;
    }

    // Insertion average = O(log n) - worst case = O(n)
    public void insert(T value) {
        this.root = this.insertRecursively(this.root, value);
    }

    private BinarySearchTreeNode<T> insertRecursively(BinarySearchTreeNode<T> currentNode, T value) {
        if (currentNode == null) {
            currentNode = new BinarySearchTreeNode<>(value);
            return currentNode;
        }

        // check where to add
        int comparison = value.compareTo(currentNode.getValue());

        if (comparison > 0) {
            currentNode.setRight(this.insertRecursively(currentNode.getRight(), value));
        } else if (comparison < 0) {
            currentNode.setLeft(this.insertRecursively(currentNode.getLeft(), value));
        }

        return currentNode;
    }

    // Search average = O(log n) - worst case = O(n)
    public boolean search(T value) {
        return this.searchRecursively(this.root, value);
    }

    private boolean searchRecursively(BinarySearchTreeNode<T> currentNode, T value) {
        if (currentNode == null) return false;

        // check comparison
        int comparison = value.compareTo(currentNode.getValue());

        if (comparison == 0) {
            return true;
        } else if (comparison > 0) {
            return this.searchRecursively(currentNode.getRight(), value);
        } else {
            return this.searchRecursively(currentNode.getLeft(), value);
        }
    }
}
