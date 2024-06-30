package com.lucio.algo.structure.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SinglyListTest {
    SinglyList<Integer> integerLinkedList;
    SinglyList<Integer> emptyLinkedList;

    @BeforeEach
    public void setup() {
        integerLinkedList = new SinglyList<>();
        emptyLinkedList = new SinglyList<>();

        for (int i = 0; i <= 10; i++) {
            integerLinkedList.push(i);
        }
    }

    @Test()
    @DisplayName("Test length of integer linked list")
    public void sizeTest() {
        int expectedSize = 11;
        int unexpectedSize = 10;

        Assertions.assertEquals(this.integerLinkedList.getSize(), expectedSize);
        Assertions.assertNotEquals(this.integerLinkedList.getSize(), unexpectedSize);
    }

    @Test
    @DisplayName("Test get method in linked list")
    public void getTest() {
        int negativeInvalidIndex = -1;
        int positiveInvalidIndex = 16;

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> integerLinkedList.get(negativeInvalidIndex));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> integerLinkedList.get(positiveInvalidIndex));

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
    public void getFirstValueTest() {
        int value = 0;
        Assertions.assertEquals(value, integerLinkedList.getFirstValue());
    }

    @Test
    @DisplayName("Test get last value method in linked list")
    public void getLastValueTest() {
        int value = 10;
        Assertions.assertEquals(value, integerLinkedList.getLastValue());
    }

    @Test
    @DisplayName("Test push method in linked list")
    public void pushTest() {
        int value = 11;
        integerLinkedList.push(value);

        Assertions.assertEquals(value, integerLinkedList.getLastValue());
    }

    @Test
    @DisplayName("Test insert method in linked list")
    public void insertTest() {
        // Given
        int value = 100;
        int index = 2;

        // When
        integerLinkedList.insertOnIndex(index, value);

        // Then
        Assertions.assertEquals(value,
                integerLinkedList.get(index)
                        .getValue());
    }

    @Test
    @DisplayName("Test set method in linked list")
    public void setTest() {
        // Given
        int index = 0;
        int value = -6;

        // When
        integerLinkedList.set(index, value);

        // Then
        Assertions.assertEquals(value, integerLinkedList.getFirstValue());
    }

    @Test
    @DisplayName("Test remove method in linked list")
    public void removeTest() {
        // Given
        int index = 2;

        // When
        integerLinkedList.removeAt(index);

        // Then
        Assertions.assertNotEquals(index,
                integerLinkedList.get(index)
                        .getValue());
    }

    @Test
    @DisplayName("Test pop method in linked list")
    public void popTest() {
        int actualPop = integerLinkedList.pop();
        int expectedPop = 10;

        Assertions.assertEquals(expectedPop, actualPop);

        // ________________________

        // Test popping nothing
        Assertions.assertNull(emptyLinkedList.pop());
    }

    @Test
    @DisplayName("Test shift method in linked list")
    public void shiftTest() {
        int expectedValueAfterShift = 1;
        int expectedShift = 0;
        int actualShift = integerLinkedList.shift();

        Assertions.assertEquals(expectedShift, actualShift);
        Assertions.assertEquals(expectedValueAfterShift, integerLinkedList.getFirstValue());

        // ________________________

        // Test shift nothing
        Assertions.assertNull(emptyLinkedList.pop());
    }

    @Test
    @DisplayName("Test unshift method in linked list")
    public void unshiftTest() {
        int expected = -1;
        integerLinkedList.unshift(expected);

        Assertions.assertEquals(expected, integerLinkedList.getFirstValue());
    }

    @Test
    @DisplayName("Test reverse method in linked list")
    public void reverseTest() {
        integerLinkedList.reverse();

        for (int i = 0, a = integerLinkedList.getSize() - 1; i < integerLinkedList.getSize(); i++, a--) {
            Assertions.assertEquals(a,
                    integerLinkedList.get(i)
                            .getValue());
        }
    }

    @Test
    @DisplayName("Test is empty method in linked list")
    public void isEmptyTest() {
        Assertions.assertTrue(this.emptyLinkedList.isEmpty());
        Assertions.assertFalse(this.integerLinkedList.isEmpty());
    }
}
