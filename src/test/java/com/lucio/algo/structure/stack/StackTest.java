package com.lucio.algo.structure.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test()
    @DisplayName("Test length of integer stack")
    public void sizeOfLinkedListExpectingElevenToReturnTest() {
        int expectedSizeForFilledStack = 10;
        int expectedSizeForEmptyStack = 0;

        Assertions.assertEquals(this.stack.getSize(), expectedSizeForFilledStack);
        Assertions.assertNotEquals(this.emptyStack.getSize(), expectedSizeForEmptyStack);
    }

    @Test()
    @DisplayName("Test Pop of integer stack")
    public void popTest() {
        int expectedValueForFilledStack = 10;

        Assertions.assertEquals(this.stack.pop(), expectedValueForFilledStack);
        Assertions.assertNull(this.emptyStack.pop());
    }
}

