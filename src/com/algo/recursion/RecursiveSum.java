package com.algo.recursion;

public class RecursiveSum {
    public static void main(String[] args) {
        int summedNumber = sum(3);
        System.out.println(summedNumber);
    }

    private static int sum(int number) {

        // base
        if (number == 0)
            return 0;

        return number + sum(number - 1);
    }
}
