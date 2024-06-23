package com.lucio.algo.search;

public class LinearSearchApp {
    public static void main(String[] args) {
        int[] intArray = new int[400];
        for (int i = 0; i < intArray.length; i++)
            intArray[i] = i * 100;

        // check if number exists
        System.out.println(getItemOfIndex(intArray, 5900));

    }

    // linear search
    public static int getItemOfIndex(int[] intArray, int number) {

        for (int i = 0; i < intArray.length; i++)
            if (intArray[i] == number) return i;

        return -1;
    }

}
