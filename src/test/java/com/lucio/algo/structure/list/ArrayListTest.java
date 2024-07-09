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

}
