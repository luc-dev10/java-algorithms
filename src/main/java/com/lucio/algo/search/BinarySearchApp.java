package com.lucio.algo.search;

public class BinarySearchApp {
    public static void main(String[] args) {

        int[] intArray = new int[400];
        for (int i = 0; i < intArray.length; i++)
            intArray[i] = i * 100;

        // check if number exists
        System.out.println(getIndexOfItems(intArray, 900));

    }

    public static int getIndexOfItems(int[] items, int number) {

        int mid = items.length / 2;
        int end = items.length - 1;
        int start = 0;

        while (start != end) {

            if (number == items[mid]) return mid;

            if (number > items[mid]) start = mid + 1;
            else end = mid - 1;

            mid = (end + start) / 2;
        }

        return -1;
    }
}
