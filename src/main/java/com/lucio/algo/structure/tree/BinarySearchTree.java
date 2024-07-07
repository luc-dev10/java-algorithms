package com.lucio.algo.structure.tree;

import com.lucio.algo.structure.list.SinglyList;
import com.lucio.algo.structure.node.BinaryTreeNode;
import com.lucio.algo.structure.queue.Queue;

public class BinarySearchTree<T extends Comparable<T>> {
    private BinaryTreeNode<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public BinaryTreeNode<T> getRoot() {
        return this.root;
    }

    // Insertion average = O(log n) - worst case = O(n)
    public void insert(T value) {
        this.root = this.insertRecursively(this.root, value);
    }

    private BinaryTreeNode<T> insertRecursively(BinaryTreeNode<T> currentNode, T value) {
        if (currentNode == null) {
            currentNode = new BinaryTreeNode<>(value);
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

    private boolean searchRecursively(BinaryTreeNode<T> currentNode, T value) {
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

    public void delete(T value) {
        this.root = this.deleteRecursively(this.root, value);
    }

    private BinaryTreeNode<T> deleteRecursively(BinaryTreeNode<T> currentNode, T value) {
        if (currentNode == null) return null;

        int comparison = value.compareTo(currentNode.getValue());
        if (comparison > 0) {
            currentNode.setRight(this.deleteRecursively(currentNode.getRight(), value));
        } else if (comparison < 0) {
            currentNode.setLeft(this.deleteRecursively(currentNode.getLeft(), value));
        } else {
            if (currentNode.getLeft() == null) return currentNode.getRight();
            else if (currentNode.getRight() == null) return currentNode.getLeft();

            // find min value in right side -> replace it with deleted value
            currentNode.setValue(this.getMinValue(currentNode.getRight()));
            currentNode.setRight(this.deleteRecursively(currentNode.getRight(), currentNode.getValue()));
        }

        return currentNode;
    }

    private T getMinValue(BinaryTreeNode<T> currentNode) {
        T value = currentNode.getValue();
        while (currentNode.getLeft() != null) {
            value = currentNode.getLeft()
                    .getValue();
            currentNode = currentNode.getLeft();
        }
        return value;
    }

    // Breadth First Implementation
    public SinglyList<T> getBreadthFirstTraversal() {
        if (this.root == null) return null;

        SinglyList<T> linkedList = new SinglyList<>();
        Queue<BinaryTreeNode<T>> queue = new Queue<>();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode<T> node = queue.dequeue();
            linkedList.push(node.getValue());
            if (node.getLeft() != null) queue.enqueue(node.getLeft());
            if (node.getRight() != null) queue.enqueue(node.getRight());
        }

        return linkedList;
    }
}
