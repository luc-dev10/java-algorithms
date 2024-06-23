package com.lucio.algo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class SinglyListTest {
    LinkedList<Integer> integerLinkedList = new LinkedList<>();

    @BeforeEach
    public void setup() {
        for (int i = 0; i <= 10; i++) {
            integerLinkedList.add(i);
        }
    }

    @Test()
    @DisplayName("Test length of integer linked list")
    public void sizeOfLinkedListExpectingElevenToReturnTest() {
        int expectedSize = 11;
        int unexpectedSize = 10;

        Assertions.assertEquals(this.integerLinkedList.size(), expectedSize);
        Assertions.assertNotEquals(this.integerLinkedList.size(), unexpectedSize);
    }
}
