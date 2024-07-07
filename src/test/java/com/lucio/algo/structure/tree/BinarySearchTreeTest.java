package com.lucio.algo.structure.tree;

import org.junit.jupiter.api.BeforeEach;

public class BinarySearchTreeTest {
    BinarySearchTree<Integer> binarySearchTree;

    @BeforeEach
    public void setup() {
        binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(20);
        binarySearchTree.insert(15);
        binarySearchTree.insert(40);

        binarySearchTree.insert(12);
        binarySearchTree.insert(17);
        binarySearchTree.insert(35);
        binarySearchTree.insert(80);

        //                       20
        //          15                              40
        //     12       17                  35               80
    }
}
