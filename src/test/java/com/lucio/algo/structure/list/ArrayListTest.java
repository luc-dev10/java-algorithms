package com.lucio.algo.structure.list;

import org.junit.jupiter.api.BeforeEach;

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
}
