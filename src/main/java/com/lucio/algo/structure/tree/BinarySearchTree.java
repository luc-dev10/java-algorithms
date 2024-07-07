package com.lucio.algo.structure.tree;

import com.lucio.algo.structure.node.BinarySearchTreeNode;

public class BinarySearchTree<T extends Comparable<T>> {
    BinarySearchTreeNode<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    // Insertion average = O(log n) - worst case = O(n)
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
            this.insertRecursively(currentNode.getRight(), value);
        } else if (comparison < 0) {
            this.insertRecursively(currentNode.getLeft(), value);
        }
    }

    // Search average = O(log n) - worst case = O(n)
    public boolean search(T value) {
        return this.searchRecursively(this.root, value);
    }

    private boolean searchRecursively(BinarySearchTreeNode<T> currentNode, T value) {
        if (currentNode == null) return false;

        // check comparison
        int comparison = currentNode.getValue()
                .compareTo(value);

        if (comparison == 0) {
            return true;
        } else if (comparison > 0) {
            this.searchRecursively(currentNode.getRight(), value);
        } else {
            this.searchRecursively(currentNode.getLeft(), value);
        }

        return false;
    }
}
