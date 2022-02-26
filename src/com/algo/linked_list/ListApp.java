package com.algo.linked_list;

public class ListApp {
    public static void main(String[] args) {

        // define list
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        integerLinkedList.push(1);
        integerLinkedList.push(2);
        integerLinkedList.push(3);

        //        printValuesFromList(integerLinkedList);
        //_____________________________

        // test pop
        integerLinkedList.pop(1);
        //        printValuesFromList(integerLinkedList);

        //_____________________________

        integerLinkedList.push(4);
        integerLinkedList.push(5);
        //        printValuesFromList(integerLinkedList);

        //_____________________________

        // test get method
        System.out.println(integerLinkedList.get(0));

        //_____________________________

        // test set on index
        integerLinkedList.set(1, 10);
        printValuesFromList(integerLinkedList);

    }

    // method to print values from list
    public static void printValuesFromList(LinkedList<Integer> integerLinkedList) {
        for (Integer i : integerLinkedList)
            System.out.printf("Item: %d\n", i);
        System.out.printf("Size: %d\n", integerLinkedList.getSize());
    }

}
