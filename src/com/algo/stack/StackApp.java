package com.algo.stack;

public class StackApp {
    public static void main(String[] args) {

        Stack<Integer> integerStack = new Stack<>();
        for (int i = 1; i < 11; i++)
            integerStack.push(i);

        // display the push
        System.out.println(integerStack.toString());

        // display after pop
        for (int i = integerStack.size(); i > 6; i--)
            System.out.printf("Popped: %d\n", integerStack.pop());

        // display the pop
        System.out.println(integerStack.toString());

    }
}
