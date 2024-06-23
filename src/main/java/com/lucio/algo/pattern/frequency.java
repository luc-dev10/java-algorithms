package com.lucio.algo.pattern;

import java.util.HashMap;
import java.util.Map;

public class frequency {
    public static void main(String[] args) {
        int[] firstArray = {1, 4, 9, 1};
        int[] secondArray = {1, 16, 81, 1};

        System.out.println(isFrequencyPresent(firstArray, secondArray));
    }

    public static boolean isFrequencyPresent(int[] firstArray, int[] secondArray) {
        if (firstArray.length != secondArray.length) return false;

        Map<Integer, Integer> firstFrequency = new HashMap<>();
        Map<Integer, Integer> secondFrequency = new HashMap<>();

        for (int i = 0; i < firstArray.length; i++) {
            firstFrequency.put(firstArray[i], firstFrequency.getOrDefault(firstArray[i]++, 0));
            secondFrequency.put(secondArray[i], secondFrequency.getOrDefault(secondArray[i]++, 0));
        }

        for (Integer key : firstFrequency.keySet()) {
            int secondKey = key * key;
            int firstValue = firstFrequency.get(key);

            if (!secondFrequency.containsKey(secondKey) || secondFrequency.get(secondKey) != firstValue) return false;
        }

        return true;
    }
}
