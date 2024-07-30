package com.lucio.algo.structure.node;

public class PriorityQueueNode<T> implements Comparable<PriorityQueueNode<T>> {
    private T value;
    private int priority;

    public PriorityQueueNode(T value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(PriorityQueueNode priorityQueueNode) {
        return Integer.compare(priority, priorityQueueNode.getPriority());
    }
}
