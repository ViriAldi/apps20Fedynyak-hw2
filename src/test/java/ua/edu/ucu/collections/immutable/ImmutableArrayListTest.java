package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    
    @Test
    public void testSomeMethod() {
        ImmutableArrayList arr = new ImmutableArrayList(new Object[]{1, 2, 3});
        assertEquals(arr.toString(), "1,2,3");
    }
    
}
