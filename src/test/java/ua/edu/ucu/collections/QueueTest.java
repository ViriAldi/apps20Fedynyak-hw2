package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    
    @Test
    public void testEnqueue() {
        Queue q = new Queue();
        q.enqueue(11);
        q.enqueue(22);
        q.enqueue(33);
        assertEquals(q.toString(), "TAIL 33,22,11 HEAD");
    }

    @Test
    public void testDequeue() {
        Queue q = new Queue();
        q.enqueue(11);
        q.enqueue(22);
        q.enqueue(33);
        Object a = q.dequeue();
        Object b = q.dequeue();
        assertEquals(q.toString(), "TAIL 33 HEAD");
        assertEquals(a, 11);
        assertEquals(b, 22);
    }

    @Test
    public void testPeek() {
        Queue q = new Queue();
        q.enqueue(11);
        q.enqueue(22);
        q.enqueue(33);
        assertEquals(q.peek(), 11);
        q.dequeue();
        assertEquals(q.peek(), 22);

    }
    
}
