package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    ImmutableLinkedList items;
    public Queue(Object[] array){
        this.items = new ImmutableLinkedList(array);
    }

    Object peek(){
        return this.items.getFirst();
    }

    Object dequeue(){
        Object first = this.peek();
        this.items = this.items.removeFirst();
        return first;
    }

    void enqueue(Object e){
        this.items = this.items.addLast(e);
    }

    @Override
    public String toString(){
        return this.items.toString();
    }
}
