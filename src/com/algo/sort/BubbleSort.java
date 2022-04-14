package com.algo.sort;

public class BubbleSort {
    public static void main(String[] args) {

        // create list
        int[] numbers = new int[]{3, 6, 10, 7, 1};
        sort(numbers);

        for (int number : numbers)
            System.out.println(number);

    }

    public static void sort(int[] numbers) {

        boolean isSwapped;
        for (int i = numbers.length; i > 0; i--) {
            isSwapped = true;
            for (int j = 0; j < i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    isSwapped = false;
                }
            }

            if (isSwapped)
                break;
        }

    }
}
