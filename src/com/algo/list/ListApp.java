package com.algo.list;

public class ListApp {
    public static void main(String[] args) {

        // define list
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        integerLinkedList.push(1);
        //        integerLinkedList.push(2);
        //        integerLinkedList.push(3);

        printValuesFromList(integerLinkedList);
        //_____________________________

        // test pop
        integerLinkedList.pop(1);
        printValuesFromList(integerLinkedList);

        //_____________________________

    }

    // method to print values from list
    public static void printValuesFromList(LinkedList<Integer> integerLinkedList) {
        for (Integer i : integerLinkedList)
            System.out.printf("Item: %d\n", i);
        System.out.printf("Size: %d\n", integerLinkedList.getSize());
    }

}
