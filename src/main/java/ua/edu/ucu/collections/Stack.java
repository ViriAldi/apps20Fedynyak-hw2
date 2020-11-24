package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    ImmutableLinkedList items;
    public Stack() {
        this.items = new ImmutableLinkedList(new Object[]{});
    }

    Object peek() {
        return this.items.getLast();
    }

    Object pop () throws IndexOutOfBoundsException {
        Object first = this.peek();
        this.items = this.items.removeLast();
        return first;
    }

    void push(Object e) {
        this.items = this.items.addLast(e);
    }

    @Override
    public String toString() {
        return "BOTTOM " + this.items.toString() + " TOP";
    }
}
