package com.lucio.algo.structure.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DoublyListTest {
    DoublyList<Integer> integerLinkedList;
    DoublyList<Integer> emptyLinkedList;

    @BeforeEach
    public void setup() {
        integerLinkedList = new DoublyList<>();
        emptyLinkedList = new DoublyList<>();

        // populate integer list
        for (int i = 0; i <= 10; i++) {
            integerLinkedList.push(i);
        }
    }

    @Test()
    @DisplayName("Test length of integer linked list")
    public void sizeOfLinkedListExpectingElevenToReturnTest() {
        int expectedSize = 11;
        int unexpectedSize = 10;

        Assertions.assertEquals(this.integerLinkedList.getSize(), expectedSize);
        Assertions.assertNotEquals(this.integerLinkedList.getSize(), unexpectedSize);
    }

}
