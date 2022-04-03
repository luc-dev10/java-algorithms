package com.algo.doubly_list;

public class DoublyListApp {

    public static void main(String[] args) {
        DoublyList<Integer> integerDoublyList = new DoublyList<>();
        integerDoublyList.push(1);
        integerDoublyList.push(2);
        integerDoublyList.push(3);
        integerDoublyList.push(4);
        integerDoublyList.push(5);
        integerDoublyList.push(6);
        integerDoublyList.push(7);
        integerDoublyList.push(8);

        //        // pop
        //        integerDoublyList.pop();
        //        integerDoublyList.pop();
        //
        //        // shift
        //        integerDoublyList.shift();
        //
        //        // unshift
        //        integerDoublyList.unshift(100);
        //        integerDoublyList.unshift(200);
        //
        //        // print size
        //        System.out.printf("Size: %d\n", integerDoublyList.getSize());
        //
        //        // get method
        //        System.out.printf("Value :%d\n", integerDoublyList.get(0));
        //
        //        // set method
        //        printList(integerDoublyList);
        //        System.out.println(integerDoublyList.set(3, 300));
        //        printList(integerDoublyList);

        // test insert
        //        integerDoublyList.insert(integerDoublyList.getSize(), 10);

        integerDoublyList.insert(0, 0);
        integerDoublyList.insert(1, 1000);
        integerDoublyList.insert(2, 2000);
        integerDoublyList.insert(3, 3000);
        integerDoublyList.insert(4, 4000);
        integerDoublyList.insert(5, 5000);
        integerDoublyList.insert(6, 6000);
        integerDoublyList.insert(7, 7000);
        integerDoublyList.insert(8, 8000);

        printList(integerDoublyList);

    }

    // loop to print
    public static <E> void printList(DoublyList<E> doublyList) {
        for (E e : doublyList)
            System.out.println(e);
    }
}
