package com.lucio.algo.structure.stack;

import org.junit.jupiter.api.BeforeEach;

public class StackTest {
    Stack<Integer> stack;
    Stack<Integer> emptyStack;

    @BeforeEach
    public void setup() {
        stack = new Stack<>();
        emptyStack = new Stack<>();

        // populate integer stack
        for (int i = 0; i <= 10; i++) {
            stack.push(i);
        }
    }
}

