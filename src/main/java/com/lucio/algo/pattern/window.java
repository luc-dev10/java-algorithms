package com.lucio.algo.pattern;

public class window {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 6, 2, 2, 2};
        System.out.println(sumOnSubset(numbers, 3));
    }

    public static int sumOnSubset(int[] numbers, int subset) {
        if (numbers.length < subset) return 0;

        int total = 0;
        for (int i = 0; i < subset; i++)
            total += numbers[i];

        int temp = total;
        for (int i = subset; i < numbers.length; i++) {
            temp = temp - numbers[i - subset] + numbers[i];
            total = Math.max(temp, total);
        }

        return total;
    }
}
