package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    @Test
    public void testConstructor() {
        ImmutableArrayList arr = new ImmutableArrayList(new Object[]{1, 2, 3, "jaba"});
        assertEquals(arr.toString(), "1,2,3,jaba");
    }

    @Test
    public void testToArray() {
        ImmutableArrayList arr = new ImmutableArrayList(new Object[]{1, 2, 3, "jaba"});
        assertEquals(Arrays.toString(arr.toArray()), "[1, 2, 3, jaba]");
    }

    @Test
    public void testAdd() {
        ImmutableArrayList arr = new ImmutableArrayList(new Object[]{1, 2, 3, "jaba"});
        ImmutableArrayList arr1 = arr.add("JabA");
        assertEquals(arr1.toString(), "1,2,3,jaba,JabA");
    }

    @Test
    public void testAddIndex() {
        ImmutableArrayList arr = new ImmutableArrayList(new Object[]{1, 2, 3, "jaba"});
        ImmutableArrayList arr1 = arr.add(2, "JabA");
        assertEquals(arr1.toString(), "1,2,JabA,3,jaba");
    }

    @Test
    public void testGet() {
        ImmutableArrayList arr = new ImmutableArrayList(new Object[]{1, 2, 3, "jaba"});
        Object item = arr.get(3);
        assertEquals(item, "jaba");
    }

    @Test
    public void testRemove() {
        ImmutableArrayList arr = new ImmutableArrayList(new Object[]{1, 2, 3, "jaba"});
        ImmutableArrayList arr1 = arr.remove(2);
        assertEquals(arr1.toString(), "1,2,jaba");
    }

    @Test
    public void testSet() {
        ImmutableArrayList arr = new ImmutableArrayList(new Object[]{1, 2, 3, "jaba"});
        ImmutableArrayList arr1 = arr.set(1, "JaBa");
        assertEquals(arr1.toString(), "1,JaBa,3,jaba");
    }

    @Test
    public void testIndexOfFound() {
        ImmutableArrayList arr = new ImmutableArrayList(new Object[]{1, 2, 3, "jaba"});
        int index = arr.indexOf("jaba");
        assertEquals(index, 3);
    }

    @Test
    public void testIndexOfNotFound() {
        ImmutableArrayList arr = new ImmutableArrayList(new Object[]{1, 2, 3, "jaba"});
        int index = arr.indexOf("JaBa");
        assertEquals(index, -1);
    }

    @Test
    public void testSize() {
        ImmutableArrayList arr = new ImmutableArrayList(new Object[]{1, 2, 3, "jaba", "JABA"});
        int size = arr.size();
        assertEquals(size, 5);
    }

    @Test
    public void testIsEmptyIfEmpty() {
        ImmutableArrayList arr = new ImmutableArrayList(new Object[]{});
        assertTrue(arr.isEmpty());
    }

    @Test
    public void testIsEmptyIfNotEmpty() {
        ImmutableArrayList arr = new ImmutableArrayList(new Object[]{"jabaaa"});
        assertFalse(arr.isEmpty());
    }

    @Test
    public void testClear() {
        ImmutableArrayList arr = new ImmutableArrayList(new Object[]{"jabaa", "jabba", 1, 0.1});
        assertEquals(arr.clear(0).toString(), "0,0,0,0");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWrongIndex() {
        ImmutableArrayList arr = new ImmutableArrayList(new Object[]{1, 2, 3, "jaba"});
        arr.get(10);
    }
    
}
