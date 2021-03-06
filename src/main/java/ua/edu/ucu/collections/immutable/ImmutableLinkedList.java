package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList {
    static class Node {
        private final Object item;
        private Node next;
        private Node prev;
        public Node(Object item) {
            this.item = item;
            this.next = null;
            this.prev = null;
        }
    }
    private Node head;
    private Node tail;
    private int length;

    public ImmutableLinkedList(Object[] array) {
        this.length = array.length;
        if (this.length == 0) {
            this.tail = null;
            this.head = null;
        }
        else {
            Node prev = null;
            for (int index = 0; index < this.length; index++) {
                Node newNode = new Node(array[index]);
                newNode.prev = prev;
                if (prev != null) {
                    prev.next = newNode;
                }
                prev = newNode;
                if (index == 0) {
                    this.head = newNode;
                }
                if (index == this.length - 1) {
                    this.tail = newNode;
                }
            }
        }
    }

    public Object[] toArray() {
        Object[] array = new Object[this.length];
        int index = 0;
        Node current = this.head;
        while (current != null) {
            array[index] = current.item;
            current = current.next;
            index++;
        }
        return array;
    }

    public ImmutableLinkedList add(Object e) {
        Object[] wrapper = {e};
        return this.addAll(wrapper);
    }

    public ImmutableLinkedList addAll(Object[] c) {
        return this.addAll(this.length, c);
    }

    public ImmutableLinkedList add(int index, Object e)
            throws IndexOutOfBoundsException {
        Object[] wrapper = {e};
        return this.addAll(index, wrapper);
    }


    public ImmutableLinkedList addAll(int index, Object[] c)
            throws IndexOutOfBoundsException {
        if (index != this.length) {
            this.checkIndex(index);
        }
        Object[] newArray = new Object[this.length + c.length];
        Object[] ourArray = this.toArray();
        System.arraycopy(ourArray, 0, newArray, 0, index);
        System.arraycopy(c, 0, newArray, index, c.length);
        System.arraycopy(ourArray, index, newArray, index + c.length,
                this.length - index);
        return new ImmutableLinkedList(newArray);
    }

    public Object get(int index) throws IndexOutOfBoundsException {
        this.checkIndex(index);
        int idx = 0;
        Node current = this.head;
        while (idx != index) {
            current = current.next;
            idx++;
        }
        return current.item;
    }

    public ImmutableLinkedList remove(int index)
            throws IndexOutOfBoundsException {
        this.checkIndex(index);
        Object[] array = this.toArray();
        Object[] newArray = new Object[this.length - 1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index,
                this.length - index - 1);
        return new ImmutableLinkedList(newArray);
    }

    public ImmutableLinkedList set(int index, Object e)
            throws IndexOutOfBoundsException {
        this.checkIndex(index);
        Object[] array = this.toArray();
        array[index] = e;
        return new ImmutableLinkedList(array);
    }

    public int indexOf(Object e) {
        Node current = this.head;
        int index = 0;
        while (current != null) {
            if (current.item == e) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    public int size() {
        return this.length;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public ImmutableLinkedList clear(Object e) {
        Object[] array = new Object[this.length];
        for (int i = 0; i < this.length; i++) {
            array[i] = e;
        }
        return new ImmutableLinkedList(array);
    }

    public String toString() {
        Node current = this.head;
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < this.length; index++) {
            result.append(current.item.toString());
            current = current.next;
            if (index != this.length - 1) {
                result.append(",");
            }

        }
        return result.toString();
    }

    private void checkIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.length) {
            throw new IndexOutOfBoundsException();
        }
    }

    private ImmutableLinkedList copy() {
        return new ImmutableLinkedList(this.toArray());
    }

    public ImmutableLinkedList addFirst(Object e) {
        if (this.length == 0) {
            return new ImmutableLinkedList(new Object[]{e});
        }
        ImmutableLinkedList cpy = this.copy();
        Node newNode = new Node(e);
        newNode.next = cpy.head;
        cpy.head.prev = newNode;
        cpy.head = newNode;
        cpy.length++;
        return cpy;
    }

    public ImmutableLinkedList addLast(Object e) {
        if (this.length == 0) {
            return new ImmutableLinkedList(new Object[]{e});
        }
        ImmutableLinkedList cpy = this.copy();
        Node newNode = new Node(e);
        newNode.prev = cpy.tail;
        cpy.tail.next = newNode;
        cpy.tail = newNode;
        cpy.length++;
        return cpy;
    }

    public Object getFirst() {
        return this.head.item;
    }

    public Object getLast() {
        return this.tail.item;
    }

    public ImmutableLinkedList removeFirst() throws IndexOutOfBoundsException {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        if (this.length == 1) {
            Object[] array = {};
            return new ImmutableLinkedList(array);
        }
        ImmutableLinkedList cpy = this.copy();
        cpy.head = cpy.head.next;
        cpy.head.prev = null;
        cpy.length--;
        return cpy;
    }

    public ImmutableLinkedList removeLast() throws IndexOutOfBoundsException {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        if (this.length == 1) {
            Object[] array = {};
            return new ImmutableLinkedList(array);
        }
        ImmutableLinkedList cpy = this.copy();
        cpy.tail = cpy.tail.prev;
        cpy.tail.next = null;
        cpy.length--;
        return cpy;
    }

}
