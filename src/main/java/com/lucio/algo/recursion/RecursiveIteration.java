package com.lucio.algo.recursion;

public class RecursiveIteration {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 3, 5, 7, 4, 2};
        iterate(numbers, 0);
    }

    public static void iterate(int[] numbers, int index) {

        // base case
        if (numbers.length <= index) return;

        System.out.println(numbers[index]);
        iterate(numbers, ++index);
    }
}
