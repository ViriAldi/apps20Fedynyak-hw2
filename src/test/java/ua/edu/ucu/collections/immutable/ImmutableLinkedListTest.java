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
}
