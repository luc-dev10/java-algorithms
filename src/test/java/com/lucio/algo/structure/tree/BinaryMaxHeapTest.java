package com.lucio.algo.structure.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BinaryMaxHeapTest {
    BinaryMaxHeap<Integer> binaryMaxHeap;

    @BeforeEach
    public void setup() {
        binaryMaxHeap = new BinaryMaxHeap<>();

        // populate integer list
        for (int i = 1; i <= 10; i++) {
            binaryMaxHeap.add(i);
        }

        //               10
        //         9           6
        //     7      8     2     5
        //    1 4    3
    }

    @Test()
    @DisplayName("Test length")
    public void lengthTest() {
        int expectedSize = 10;
        Assertions.assertEquals(this.binaryMaxHeap.getSize(), expectedSize);
    }

    @Test()
    @DisplayName("Test peek")
    public void peekTest() {
        int expected = 10;
        Assertions.assertEquals(this.binaryMaxHeap.peek(), expected);
    }

    @Test()
    @DisplayName("Test Add")
    public void addTest() {
        int value = 15;

        this.binaryMaxHeap.add(value);
        Assertions.assertEquals(this.binaryMaxHeap.peek(), value);
    }

    @Test()
    @DisplayName("Test poll")
    public void pollTest() {
        int expected = 10;
        int actual = this.binaryMaxHeap.poll();

        Assertions.assertEquals(actual, expected);
        Assertions.assertNotEquals(this.binaryMaxHeap.peek(), actual);
    }

}
