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

        printValuesFromList(integerSinglyList);

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
