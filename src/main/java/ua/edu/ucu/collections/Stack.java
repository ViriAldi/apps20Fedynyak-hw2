package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    ImmutableLinkedList items;
    public Stack(Object[] array){
        this.items = new ImmutableLinkedList(array);
    }

    Object peek(){
        return this.items.getFirst();
    }

    Object pop(){
        Object first = this.peek();
        this.items = this.items.removeFirst();
        return first;
    }

    void push(Object e){
        this.items = this.items.addFirst(e);
    }
}
