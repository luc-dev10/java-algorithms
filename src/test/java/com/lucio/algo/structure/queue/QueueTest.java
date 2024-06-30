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

    @Test()
    @DisplayName("Test dequeue of integer queue")
    public void dequeueTest() {
        int expectedValue = 0;

        Assertions.assertEquals(this.queue.dequeue(), expectedValue);
        Assertions.assertNull(this.emptyQueue.dequeue());
    }

    @Test()
    @DisplayName("Test peek of integer queue")
    public void peekTest() {
        int expectedValue = 0;

        Assertions.assertEquals(this.queue.peek(), expectedValue);
        Assertions.assertNull(this.emptyQueue.peek());
    }

    @Test()
    @DisplayName("Test is empty of integer queue")
    public void isEmptyTest() {
        Assertions.assertTrue(this.emptyQueue.isEmpty());
        Assertions.assertFalse(this.queue.isEmpty());
    }
}
