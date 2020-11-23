package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void testPush() {
        Stack s = new Stack();
        s.push(228);
        s.push(1337);
        s.push(1488);
        assertEquals(s.toString(), "BOTTOM 228,1337,1488 TOP");
    }

    @Test
    public void testPop() {
        Stack s = new Stack();
        s.push(228);
        s.push(1337);
        s.push(1488);
        Object a = s.pop();
        Object b = s.pop();
        assertEquals(s.toString(), "BOTTOM 228 TOP");
        assertEquals(a, 1488);
        assertEquals(b, 1337);
    }

    @Test
    public void testPeek() {
        Stack s = new Stack();
        s.push(228);
        s.push(1337);
        s.push(1488);
        assertEquals(s.peek(), 1488);
        s.pop();
        assertEquals(s.peek(), 1337);
    }
    
}
