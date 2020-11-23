package ua.edu.ucu.collections.immutable;


public class ImmutableArrayList implements ImmutableList {
    private final Object[] items;
    private final int length;
    public ImmutableArrayList(Object[] array){
        this.items = array;
        this.length = array.length;
    }

    public ImmutableArrayList add(Object e) {
        Object[] wrapper = {e};
        return this.addAll(wrapper);
    }

    public ImmutableArrayList addAll(Object[] c) {
        return this.addAll(this.length, c);
    }

    public ImmutableArrayList add(int index, Object e) throws IndexOutOfBoundsException{
        Object[] wrapper = {e};
        return this.addAll(index, wrapper);
    }

    public ImmutableArrayList addAll(int index, Object[] c) throws IndexOutOfBoundsException{
        if (index != this.length) {
            this.checkIndex(index);
        }
        Object[] new_array = new Object[this.length + c.length];
        System.arraycopy(this.items, 0, new_array, 0, index);
        System.arraycopy(c, 0, new_array, index, c.length);
        System.arraycopy(this.items, index, new_array, index + c.length, this.length - index);
        return new ImmutableArrayList(new_array);
    }

    public Object get(int index) throws IndexOutOfBoundsException{
        this.checkIndex(index);
        return this.items[index];
    }

    public ImmutableArrayList remove(int index) throws IndexOutOfBoundsException{
        this.checkIndex(index);
        Object[] new_array = new Object[this.length - 1];
        System.arraycopy(this.items, 0, new_array, 0, index);
        System.arraycopy(this.items, index + 1, new_array, index, this.length - index - 1);
        return new ImmutableArrayList(new_array);
    }

    public ImmutableArrayList set(int index, Object e) throws IndexOutOfBoundsException{
        this.checkIndex(index);
        Object[] new_array = new Object[this.length];
        System.arraycopy(this.items, 0, new_array, 0, this.length);
        new_array[index] = e;
        return new ImmutableArrayList(new_array);
    }

    public int indexOf(Object e) {
        for (int index = 0; index < this.length; index++){
            if (e == this.items[index]){
                return index;
            }
        }
        return -1;
    }

    public int size() {
        return this.length;
    }

    public ImmutableArrayList clear(Object e) {
        Object[] new_array = new Object[this.length];
        for (int i = 0; i < this.length; i++) {
            new_array[i] = e;
        }
        return new ImmutableArrayList(new_array);
    }

    public boolean isEmpty() {
        return (this.length == 0);
    }

    public Object[] toArray() {
        Object[] new_array = new Object[this.length];
        System.arraycopy(this.items, 0, new_array, 0, this.length);
        return new_array;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < this.length; index++){
            result.append(this.items[index].toString());
            if (index != this.length - 1){
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
}
