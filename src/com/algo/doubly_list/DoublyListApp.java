package com.algo.doubly_list;

public class DoublyListApp {

    public static void main(String[] args) {
        DoublyList<Integer> integerDoublyList = new DoublyList<>();
        integerDoublyList.push(1);
        integerDoublyList.push(2);
        integerDoublyList.push(3);
        integerDoublyList.push(4);

        // print list
        printList(integerDoublyList);

        // print size
        System.out.printf("Size: %d", integerDoublyList.getSize());
    }

    // loop to print
    public static <E> void printList(DoublyList<E> doublyList) {
        for (E e : doublyList)
            System.out.println(e);
    }
}
