package com.lucio.algo.structure.tree;

import com.lucio.algo.structure.node.BinarySearchTreeNode;

public class BinarySearchTree<T extends Comparable<T>> {
    BinarySearchTreeNode<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    // Insertion
    public void insert(T value) {
        this.insertRecursively(this.root, value);
    }

    private void insertRecursively(BinarySearchTreeNode<T> currentNode, T value) {
        if (currentNode == null) {
            currentNode = new BinarySearchTreeNode<>(value);
            return;
        }

        // check where to add
        int comparison = currentNode.getValue()
                .compareTo(value);

        if (comparison > 0) {
            insertRecursively(currentNode.getRight(), value);
        } else if (comparison < 0) {
            insertRecursively(currentNode.getLeft(), value);
        }
    }
}
