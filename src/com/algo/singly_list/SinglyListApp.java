package com.algo.singly_list;

public class SinglyListApp {
    public static void main(String[] args) {

        // define list
        SinglyList<Integer> integerSinglyList = new SinglyList<>();
        for (int i = 0; i < 10; i++) {
            integerSinglyList.push(i);
        }

        //_____________________________

        //        // test pop
        //        integerSinglyList.pop();
        //        //        integerLinkedList.pop();
        //        //        integerLinkedList.pop();
        //        printValuesFromList(integerSinglyList);

        //_____________________________

        // reverse
        integerSinglyList.reverse();
        //        printValuesFromList(integerSinglyList);

        //_____________________________

        // shift
        for (int i = 0; i < 5; i++) {
            integerSinglyList.unshift(i * 10);
        }

        // pop
        while (integerSinglyList.getSize() > 0)
            integerSinglyList.pop();

        printValuesFromList(integerSinglyList);

    }

    // method to print values from list
    public static void printValuesFromList(SinglyList<Integer> integerLinkedList) {
        for (Integer i : integerLinkedList)
            System.out.printf("Item: %d\n", i);
        System.out.printf("Size: %d\n", integerLinkedList.getSize());
    }

}
