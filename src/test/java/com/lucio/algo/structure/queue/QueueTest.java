package com.lucio.algo.structure.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class QueueTest {
    Queue<Integer> queue;
    Queue<Integer> emptyQueue;

    @BeforeEach
    public void setup() {
        queue = new Queue<>();
        emptyQueue = new Queue<>();

        // populate integer stack
        for (int i = 0; i <= 10; i++) {
            queue.enqueue(i);
        }
    }

    @Test()
    @DisplayName("Test length of integer queue")
    public void sizeTest() {
        int expectedSizeOfFilledQueue = 11;
        int expectedSizeOfEmptyQueue = 0;

        Assertions.assertEquals(this.queue.getSize(), expectedSizeOfFilledQueue);
        Assertions.assertEquals(this.emptyQueue.getSize(), expectedSizeOfEmptyQueue);
    }
}
