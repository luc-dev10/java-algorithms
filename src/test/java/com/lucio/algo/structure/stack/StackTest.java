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
        int expectedSizeForFilledStack = 11;
        int expectedSizeForEmptyStack = 0;

        Assertions.assertEquals(this.stack.getSize(), expectedSizeForFilledStack);
        Assertions.assertEquals(this.emptyStack.getSize(), expectedSizeForEmptyStack);
    }

    @Test()
    @DisplayName("Test Pop of integer stack")
    public void popTest() {
        int expectedValueForFilledStack = 10;

        Assertions.assertEquals(this.stack.pop(), expectedValueForFilledStack);
        Assertions.assertNull(this.emptyStack.pop());
    }

    @Test()
    @DisplayName("Test push of integer stack")
    public void pushTest() {
        int expectedValueForFilledStack = 11;
        int expectedSizeForFilledStack = 12;

        this.stack.push(expectedValueForFilledStack);
        Assertions.assertEquals(this.stack.getSize(), expectedSizeForFilledStack);
        Assertions.assertEquals(this.stack.pop(), expectedValueForFilledStack);
    }

    @Test()
    @DisplayName("Test peek of integer queue")
    public void peekTest() {
        int expectedValue = 10;

        Assertions.assertEquals(this.stack.peek(), expectedValue);
        Assertions.assertNull(this.emptyStack.peek());
    }

    @Test()
    @DisplayName("Test is empty of integer stack")
    public void isEmptyTest() {
        Assertions.assertTrue(this.emptyStack.isEmpty());
        Assertions.assertFalse(this.stack.isEmpty());
    }
}

