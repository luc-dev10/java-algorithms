package com.lucio.algo.structure.tree;

import org.junit.jupiter.api.BeforeEach;

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

}
