package com.algo.singly_list;

public class SinglyListApp {
    public static void main(String[] args) {

        // define list
        SinglyList<Integer> integerSinglyList = new SinglyList<>();
        integerSinglyList.push(1);
        integerSinglyList.push(2);
        integerSinglyList.push(3);

        //_____________________________

        // test pop
        integerSinglyList.pop();
        //        integerLinkedList.pop();
        //        integerLinkedList.pop();
        printValuesFromList(integerSinglyList);

        //_____________________________

        // reverse
        integerSinglyList.reverse();
        printValuesFromList(integerSinglyList);

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
    public static void printValuesFromList(SinglyList<Integer> integerLinkedList) {
        for (Integer i : integerLinkedList)
            System.out.printf("Item: %d\n", i);
        System.out.printf("Size: %d\n", integerLinkedList.getSize());
    }

}
