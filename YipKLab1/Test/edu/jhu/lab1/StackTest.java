package edu.jhu.lab1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void testEmptyStack() {
        Stack stack = new Stack();
        assertTrue(stack.isEmpty());
        assertEquals(stack.size(), 0);
        //TODO: test empty pop: assertThrows("Cannot perform operation on empty stack.");
    }

    @Test
    void testPush() {
        Stack stack = new Stack();
        stack.push("First item");
        assertEquals(stack.size(), 1);
    }

    @Test
    void testPushAndPeek() throws Exception {
        Stack stack = new Stack();
        stack.push("First item");
        stack.push("Second item");
        assertEquals(stack.size(), 2);
        assertEquals(stack.peek(), "Second item");
        assertEquals(stack.size(), 2);
    }

    @Test
    void testPop() throws Exception {
        Stack stack = new Stack();
        stack.push("First item");
        stack.push("Second item");
        assertEquals(stack.size(), 2);
        assertEquals(stack.pop(), "Second item");
        assertEquals(stack.size(), 1);
        assertEquals(stack.pop(), "First item");
        assertEquals(stack.size(), 0);
    }
}