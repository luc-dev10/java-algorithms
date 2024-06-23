package com.lucio.algo.sort;

public class InsertionSort {

    public static void main(String[] args) {

        int[] numbers = new int[]{3, 5, 3, 10, 43, 102, 4, 7, 19};
        insertionSort(numbers);

        for (int i : numbers)
            System.out.println(i);
    }

    public static void insertionSort(int[] numbers) {

        for (int i = 1; i < numbers.length; i++) {

            // hold lowest value
            int temp = numbers[i];

            int j = i - 1;
            while (j >= 0 && numbers[j] > temp) numbers[j + 1] = numbers[j--];

            // swap value at the location after loop with lowest
            numbers[j + 1] = temp;
        }
    }
}
