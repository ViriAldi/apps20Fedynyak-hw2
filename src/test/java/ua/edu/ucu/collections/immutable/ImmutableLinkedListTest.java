package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    
    @Test
    public void testConstructor() {
        ImmutableLinkedList arr = new ImmutableLinkedList(new Object[]{1, 2, 3, "jaba"});
        assertEquals(arr.toString(), "1,2,3,jaba");
    }

    @Test
    public void testToArray() {
        ImmutableLinkedList arr = new ImmutableLinkedList(new Object[]{1, 2, 3, "jaba"});
        assertEquals(Arrays.toString(arr.toArray()), "[1, 2, 3, jaba]");
    }

    @Test
    public void testAdd() {
        ImmutableLinkedList arr = new ImmutableLinkedList(new Object[]{1, 2, 3, "jaba"});
        ImmutableLinkedList arr1 = arr.add("JabA");
        assertEquals(arr1.toString(), "1,2,3,jaba,JabA");
    }

    @Test
    public void testAddIndex() {
        ImmutableLinkedList arr = new ImmutableLinkedList(new Object[]{1, 2, 3, "jaba"});
        ImmutableLinkedList arr1 = arr.add(2, "JabA");
        assertEquals(arr1.toString(), "1,2,JabA,3,jaba");
    }

    @Test
    public void testGet() {
        ImmutableLinkedList arr = new ImmutableLinkedList(new Object[]{1, 2, 3, "jaba"});
        Object item = arr.get(3);
        assertEquals(item, "jaba");
    }

    @Test
    public void testRemove() {
        ImmutableLinkedList arr = new ImmutableLinkedList(new Object[]{1, 2, 3, "jaba"});
        ImmutableLinkedList arr1 = arr.remove(2);
        assertEquals(arr1.toString(), "1,2,jaba");
    }

    @Test
    public void testSet() {
        ImmutableLinkedList arr = new ImmutableLinkedList(new Object[]{1, 2, 3, "jaba"});
        ImmutableLinkedList arr1 = arr.set(1, "JaBa");
        assertEquals(arr1.toString(), "1,JaBa,3,jaba");
    }

    @Test
    public void testIndexOfFound() {
        ImmutableLinkedList arr = new ImmutableLinkedList(new Object[]{1, 2, 3, "jaba"});
        int index = arr.indexOf("jaba");
        assertEquals(index, 3);
    }

    @Test
    public void testIndexOfNotFound() {
        ImmutableLinkedList arr = new ImmutableLinkedList(new Object[]{1, 2, 3, "jaba"});
        int index = arr.indexOf("JaBa");
        assertEquals(index, -1);
    }

    @Test
    public void testSize() {
        ImmutableLinkedList arr = new ImmutableLinkedList(new Object[]{1, 2, 3, "jaba", "JABA"});
        int size = arr.size();
        assertEquals(size, 5);
    }

    @Test
    public void testIsEmptyIfEmpty() {
        ImmutableLinkedList arr = new ImmutableLinkedList(new Object[]{});
        assertTrue(arr.isEmpty());
    }

    @Test
    public void testIsEmptyIfNotEmpty() {
        ImmutableLinkedList arr = new ImmutableLinkedList(new Object[]{"jabaaa"});
        assertFalse(arr.isEmpty());
    }

    @Test
    public void testClear() {
        ImmutableLinkedList arr = new ImmutableLinkedList(new Object[]{"jabaa", "jabba", 1, 0.1});
        assertEquals(arr.clear(0).toString(), "0,0,0,0");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWrongIndex() {
        ImmutableLinkedList arr = new ImmutableLinkedList(new Object[]{1, 2, 3, "jaba"});
        arr.get(10);
    }

    @Test
    public void testGetFirst() {
        ImmutableLinkedList arr = new ImmutableLinkedList(new Object[]{1, 2, 3, "jaba"});
        Object item = arr.getFirst();
        assertEquals(item, 1);
    }

    @Test
    public void testGetLast() {
        ImmutableLinkedList arr = new ImmutableLinkedList(new Object[]{1, 2, 3, "jaba"});
        Object item = arr.getLast();
        assertEquals(item, "jaba");
    }

    @Test
    public void testAddFirst() {
        ImmutableLinkedList arr = new ImmutableLinkedList(new Object[]{1, 2, 3, "jaba"});
        ImmutableLinkedList arr1 = arr.addFirst("DAI JABU");
        assertEquals(arr1.toString(), "DAI JABU,1,2,3,jaba");
    }

    @Test
    public void testAddLast() {
        ImmutableLinkedList arr = new ImmutableLinkedList(new Object[]{1, 2, 3, "jaba"});
        ImmutableLinkedList arr1 = arr.addLast("DAI JABU");
        assertEquals(arr1.toString(), "1,2,3,jaba,DAI JABU");
    }

    @Test
    public void testRemoveFirst() {
        ImmutableLinkedList arr = new ImmutableLinkedList(new Object[]{1, 2, 3, "jaba"});
        ImmutableLinkedList arr1 = arr.removeFirst();
        assertEquals(arr1.toString(), "2,3,jaba");
    }

    @Test
    public void testRemoveLast() {
        ImmutableLinkedList arr = new ImmutableLinkedList(new Object[]{1, 2, 3, "jaba"});
        ImmutableLinkedList arr1 = arr.removeLast();
        assertEquals(arr1.toString(), "1,2,3");
    }

    @Test
    public void testRemoveFirstLastOneElementList() {
        ImmutableLinkedList arr = new ImmutableLinkedList(new Object[]{1});
        ImmutableLinkedList arr1 = arr.removeLast();
        assertEquals(arr1.toString(), "");
        ImmutableLinkedList arr2 = arr.removeFirst();
        assertEquals(arr2.toString(), "");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveFirstFromEmptyList() {
        ImmutableLinkedList arr = new ImmutableLinkedList(new Object[]{});
        arr.removeFirst();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveLastFromEmptyList() {
        ImmutableLinkedList arr = new ImmutableLinkedList(new Object[]{});
        arr.removeLast();
    }

}
