package com.lucio.algo;

import com.lucio.algo.structure.list.SinglyList;
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

    @Test
    @DisplayName("Test get method in linked list")
    public void getMethodOfLinkedListTest() {
        SinglyList<Integer> testLinkedList = new SinglyList<>();

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> testLinkedList.get(-1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> testLinkedList.get(6));

        // ____________________

        // Expected values
        for (int i = 0; i < integerLinkedList.size(); i++) {
            Assertions.assertEquals(i, integerLinkedList.get(i));
        }
    }
}
