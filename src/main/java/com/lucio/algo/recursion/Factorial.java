package com.lucio.algo.recursion;

public class Factorial {
    public static void main(String[] args) {
        int factorialNumber = factorial(4);
        System.out.println(factorialNumber);
    }

    private static int factorial(int number) {
        if (number == 1) return 1;

        return number * factorial(--number);
    }

}
