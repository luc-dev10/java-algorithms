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

    @Test
    @DisplayName("Test get method in linked list")
    public void getMethodOfLinkedListTest() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> integerLinkedList.get(-1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> integerLinkedList.get(16));

        // ____________________

        // Expected values
        for (int i = 0; i < integerLinkedList.getSize(); i++) {
            Assertions.assertEquals(i,
                    integerLinkedList.get(i)
                            .getValue());
        }
    }

    @Test
    @DisplayName("Test get first value method in linked list")
    public void getFirstValueMethodOfLinkedListTest() {
        int value = 0;
        Assertions.assertEquals(value, integerLinkedList.getFirstValue());
    }

    @Test
    @DisplayName("Test get last value method in linked list")
    public void getLastValueMethodOfLinkedListTest() {
        int value = 10;
        Assertions.assertEquals(value, integerLinkedList.getLastValue());
    }

    @Test
    @DisplayName("Test push method in linked list")
    public void pushMethodOfLinkedListTest() {
        int value = 11;
        integerLinkedList.push(value);
        Assertions.assertEquals(value, integerLinkedList.getLastValue());
    }

    @Test
    @DisplayName("Test insert method in linked list")
    public void insertMethodOfLinkedListTest() {
        // Given
        int value = 100;
        int index = 2;

        // When
        integerLinkedList.insertOnIndex(index, value);

        // Then
        Assertions.assertAll("Assert insert index test",
                () -> Assertions.assertEquals(value,
                        integerLinkedList.get(index)
                                .getValue()),
                () -> Assertions.assertThrows(IndexOutOfBoundsException.class, () -> integerLinkedList.get(100)),
                () -> Assertions.assertThrows(IndexOutOfBoundsException.class, () -> integerLinkedList.get(-1)));
    }

    @Test
    @DisplayName("Test remove method in linked list")
    public void removeMethodOfLinkedListTest() {
        // Given
        int index = 2;

        // When
        integerLinkedList.removeAt(index);

        // Then
        Assertions.assertAll("Assert remove index test",
                () -> Assertions.assertNotEquals(index,
                        integerLinkedList.get(index)
                                .getValue()),
                () -> Assertions.assertThrows(IndexOutOfBoundsException.class, () -> integerLinkedList.get(100)),
                () -> Assertions.assertThrows(IndexOutOfBoundsException.class, () -> integerLinkedList.get(-1)));
    }

}
