package com.lucio.algo;

import com.lucio.algo.structure.list.SinglyList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SinglyListTest {
    SinglyList<Integer> integerLinkedList = new SinglyList<>();
    SinglyList<Integer> emptyLinkedList = new SinglyList<>();

    @BeforeEach
    public void setup() {
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
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> integerLinkedList.get(6));

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

    @Test
    @DisplayName("Test pop method in linked list")
    public void popMethodOfLinkedListTest() {
        int expected = 9;
        int expectedPop = 10;
        int actualPop = integerLinkedList.pop();

        Assertions.assertEquals(expected, integerLinkedList.getLastValue());
        Assertions.assertEquals(expectedPop, actualPop);
        Assertions.assertEquals(expectedPop, actualPop);

        // ________________________

        // Test popping nothing
        Assertions.assertNull(emptyLinkedList.pop());
        Assertions.assertEquals(expectedPop, integerLinkedList.getSize());
    }

    @Test
    @DisplayName("Test shift method in linked list")
    public void shiftMethodOfLinkedListTest() {
        int expected = 1;
        int expectedShift = 0;
        int actualShift = integerLinkedList.shift();

        Assertions.assertEquals(expectedShift, actualShift);
        Assertions.assertEquals(expected, integerLinkedList.getFirstValue());

        // ________________________

        // Test shift nothing
        Assertions.assertNull(emptyLinkedList.pop());
    }

    @Test
    @DisplayName("Test unshift method in linked list")
    public void unshiftMethodOfLinkedListTest() {
        int expected = -1;
        integerLinkedList.unshift(expected);

        Assertions.assertEquals(expected, integerLinkedList.getFirstValue());
    }

    @Test
    @DisplayName("Test reverse method in linked list")
    public void reverseMethodOfLinkedListTest() {
        integerLinkedList.reverse();

        for (int i = 0, a = integerLinkedList.getSize() - 1; i < integerLinkedList.getSize(); i++, a--) {
            Assertions.assertEquals(a,
                    integerLinkedList.get(i)
                            .getValue());
        }
    }
}
