package com.lucio.algo.structure.tree;

import org.junit.jupiter.api.BeforeEach;

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
}
