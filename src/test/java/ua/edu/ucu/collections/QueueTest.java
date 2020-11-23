package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    
    @Test
    public void testPush() {
        Queue q = new Queue(new Object[]{1, 2, 3});
        assertEquals(q.toString(), "1,2,3");
    }
    
}
