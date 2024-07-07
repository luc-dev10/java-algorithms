package com.lucio.algo.structure.tree;

import com.lucio.algo.structure.list.SinglyList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test()
    @DisplayName("Test search")
    public void searchTest() {
        int expectedValue = 7;
        int unexpectedValue = 90;

        Assertions.assertTrue(this.binarySearchTree.search(expectedValue));
        Assertions.assertFalse(this.binarySearchTree.search(unexpectedValue));
    }

    @Test()
    @DisplayName("Test delete")
    public void deleteTest() {
        int value = 80;
        this.binarySearchTree.delete(value);
        Assertions.assertFalse(this.binarySearchTree.search(value));
    }

    @Test()
    @DisplayName("Test breadth first")
    public void breadthFirstTest() {
        SinglyList<Integer> expectedSinglyList = new SinglyList<>();
        expectedSinglyList.push(20);
        expectedSinglyList.push(15);
        expectedSinglyList.push(40);
        expectedSinglyList.push(12);
        expectedSinglyList.push(17);
        expectedSinglyList.push(35);
        expectedSinglyList.push(80);

        SinglyList<Integer> singlyList = this.binarySearchTree.getBreadthFirstTraversal();

        Assertions.assertTrue(() -> {
            for (int i = 0; i < expectedSinglyList.getSize(); i++) {
                int currentValue = singlyList.get(i)
                        .getValue();
                int expectedValue = expectedSinglyList.get(i)
                        .getValue();

                if (currentValue != expectedValue) return false;
            }
            return true;
        });
    }

    @Test()
    @DisplayName("Test Pre Order Depth first")
    public void preOrderDepthFirstTest() {
        SinglyList<Integer> expectedSinglyList = new SinglyList<>();
        expectedSinglyList.push(20);
        expectedSinglyList.push(15);
        expectedSinglyList.push(12);
        expectedSinglyList.push(17);
        expectedSinglyList.push(40);
        expectedSinglyList.push(35);
        expectedSinglyList.push(80);

        SinglyList<Integer> singlyList = this.binarySearchTree.getPreOrderDepthFirst();

        Assertions.assertTrue(() -> {
            for (int i = 0; i < expectedSinglyList.getSize(); i++) {
                int currentValue = singlyList.get(i)
                        .getValue();
                int expectedValue = expectedSinglyList.get(i)
                        .getValue();

                if (currentValue != expectedValue) return false;
            }
            return true;
        });
    }
}
