package com.lucio.algo.structure.queue;

import org.junit.jupiter.api.BeforeEach;

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
}
