package com.lucio.algo.pattern;

public class pointer {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 2, 3, 4, 5, 5, 5, 5, 6};
        System.out.println(countUniqueValues(numbers));
    }

    public static int countUniqueValues(int[] numbers) {
        if (numbers.length == 0) return 0;

        int left = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[left] < numbers[i]) {
                numbers[++left] = numbers[i];
            }
        }

        return left + 1;
    }
}
