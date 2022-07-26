package edu.jhu.lab1;

public class Stack {
    public static class EmptyStackException extends Exception {
    }

    private Node head;
    private int size;

    private class Node {
        private String data;
        private Node next;

        // Constructor
        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public void push(String data) {
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
        size++;
    }

    public String pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            String item = head.data;
            head = head.next;
            size--;
            return item;
        }
    }

    public String peek() throws EmptyStackException {
        String item = pop();
        push(item);
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
