package com.lucio.algo.structure.tree;

import com.lucio.algo.structure.list.ArrayList;
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

    @Test()
    @DisplayName("Test iterator")
    public void iteratorTest() {
        ArrayList<Integer> expectedArrayList = new ArrayList<>();
        expectedArrayList.add(1);
        expectedArrayList.add(2);
        expectedArrayList.add(5);
        expectedArrayList.add(4);
        expectedArrayList.add(3);
        expectedArrayList.add(9);
        expectedArrayList.add(6);
        expectedArrayList.add(10);
        expectedArrayList.add(7);
        expectedArrayList.add(8);

        // ________________________

        int index = 0;
        boolean isValuesMatching = true;

        for (int value : this.binaryMinHeap) {
            if (value != expectedArrayList.get(index)) {
                isValuesMatching = false;
                break;
            }

            index++;
        }

        // _________________________

        Assertions.assertTrue(isValuesMatching);
    }
}
