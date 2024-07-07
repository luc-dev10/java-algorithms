package com.lucio.algo.structure.tree;

import com.lucio.algo.structure.node.BinarySearchTreeNode;

public class BinarySearchTree<T> {
    BinarySearchTreeNode<T> root = null;

    public BinarySearchTree(T value) {
        this.root = new BinarySearchTreeNode<>(value);
    }
}
