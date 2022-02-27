package com.algo.linked_list;

public class ListApp {
    public static void main(String[] args) {

        // define list
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        integerLinkedList.push(1);
        integerLinkedList.push(2);
        integerLinkedList.push(3);

        //_____________________________

        // test pop
        //        integerLinkedList.pop();
        //        integerLinkedList.pop();
        //        integerLinkedList.pop();
        printValuesFromList(integerLinkedList);

        //_____________________________

        // reverse
        integerLinkedList.reverse();
        printValuesFromList(integerLinkedList);
        
        //_____________________________

        //        integerLinkedList.push(4);
        //        integerLinkedList.push(5);
        //
        //        //_____________________________
        //
        //        // test set and get on index
        //        boolean isValueSetOnIndex = integerLinkedList.set(1, 10);
        //        System.out.printf("Is Value set: %b\nNew Value: %d\n", isValueSetOnIndex, integerLinkedList.get(1));
        //
        //        //_____________________________
        //
        //        // test insert
        //        boolean isNodeInserted = integerLinkedList.insertOnIndex(2, 40);
        //        System.out.printf("Is Node inserted: %b\n", isNodeInserted);
        //        printValuesFromList(integerLinkedList);

    }

    // method to print values from list
    public static void printValuesFromList(LinkedList<Integer> integerLinkedList) {
        for (Integer i : integerLinkedList)
            System.out.printf("Item: %d\n", i);
        System.out.printf("Size: %d\n", integerLinkedList.getSize());
    }

}
