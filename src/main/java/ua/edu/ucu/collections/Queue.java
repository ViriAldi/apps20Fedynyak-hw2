package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    ImmutableLinkedList items;
    public Queue() {
        this.items = new ImmutableLinkedList(new Object[]{});
    }

    Object peek() {
        return this.items.getLast();
    }

    Object dequeue() throws IndexOutOfBoundsException {
        Object first = this.peek();
        this.items = this.items.removeLast();
        return first;
    }

    void enqueue(Object e) {
        this.items = this.items.addFirst(e);
    }

    @Override
    public String toString() {
        return "TAIL " + this.items.toString() + " HEAD";
    }
}
