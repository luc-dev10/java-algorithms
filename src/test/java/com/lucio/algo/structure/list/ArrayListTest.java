package com.lucio.algo.structure.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArrayListTest {
    ArrayList<Integer> arrayList;
    ArrayList<Integer> emptyArrayList;

    @BeforeEach
    public void setup() {
        arrayList = new ArrayList<>();
        emptyArrayList = new ArrayList<>();

        // populate integer list
        for (int i = 0; i <= 10; i++) {
            arrayList.add(i);
        }
    }

    @Test()
    @DisplayName("Test length")
    public void lengthTest() {
        int expectedSize = 11;
        Assertions.assertEquals(this.arrayList.getSize(), expectedSize);
    }

    @Test()
    @DisplayName("Test isEmpty")
    public void emptyTest() {
        Assertions.assertTrue(this.emptyArrayList.isEmpty());
    }

    @Test()
    @DisplayName("Test add")
    public void addTest() {
        int value = 11;
        int size = 12;

        this.arrayList.add(value);
        Assertions.assertEquals(this.arrayList.getSize(), size);
    }

    @Test()
    @DisplayName("Test Get")
    public void getTest() {
        int expectedValue = 0;
        int unexpectedValue = 12;

        Assertions.assertEquals(this.arrayList.get(expectedValue), expectedValue);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> this.arrayList.get(unexpectedValue));
    }

    @Test()
    @DisplayName("Test remove")
    public void removeTest() {
        int value = 0;
        int index = 0;
        int expectedSize = 10;

        Assertions.assertEquals(this.arrayList.remove(index), value);
        Assertions.assertNotEquals(this.arrayList.get(index), value);
        Assertions.assertEquals(this.arrayList.getSize(), expectedSize);
    }

}
