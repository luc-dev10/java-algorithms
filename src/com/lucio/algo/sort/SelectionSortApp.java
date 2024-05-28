package com.lucio.algo.sort;

public class SelectionSortApp {
    public static void main(String[] args) {

        // create list
        int[] numbers = new int[]{3, 6, 10, 7, 1, 4, 10, 12};
        selectionSort(numbers);

        for (int number : numbers)
            System.out.println(number);

    }

    public static void selectionSort(int[] numbers) {

        for (int i = 0; i < numbers.length; i++) {

            int indexOfLowest = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[indexOfLowest]) indexOfLowest = j;
            }

            if (i != indexOfLowest) {
                int temp = numbers[i];
                numbers[i] = numbers[indexOfLowest];
                numbers[indexOfLowest] = temp;
            }

        }

    }
}
