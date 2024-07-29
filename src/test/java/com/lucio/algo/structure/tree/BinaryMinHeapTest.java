package com.lucio.algo.structure.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BinaryMinHeapTest {
    BinaryMinHeap<Integer> binaryMinHeap;

    @BeforeEach
    public void setup() {
        binaryMinHeap = new BinaryMinHeap<>();

        // populate integer list
        for (int i = 10; i > 0; i--) {
            binaryMinHeap.add(i);
        }

        //               1
        //         2           5
        //     4      3     9     6
        //   10 7    8
    }

    @Test()
    @DisplayName("Test length")
    public void lengthTest() {
        int expectedSize = 10;
        Assertions.assertEquals(this.binaryMinHeap.getSize(), expectedSize);
    }

    @Test()
    @DisplayName("Test peek")
    public void peekTest() {
        int expected = 1;
        Assertions.assertEquals(this.binaryMinHeap.peek(), expected);
    }

    @Test()
    @DisplayName("Test Add")
    public void addTest() {
        int value = 0;

        this.binaryMinHeap.add(value);
        Assertions.assertEquals(this.binaryMinHeap.peek(), value);
    }

    @Test()
    @DisplayName("Test poll")
    public void pollTest() {
        int expected = 1;
        int actual = this.binaryMinHeap.poll();

        Assertions.assertEquals(actual, expected);
        Assertions.assertNotEquals(this.binaryMinHeap.peek(), actual);
    }
}
