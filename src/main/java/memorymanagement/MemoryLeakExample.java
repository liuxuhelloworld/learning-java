package memorymanagement;

import java.util.Arrays;
import java.util.EmptyStackException;

class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        return elements[--size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == elements.length;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2*size + 1);
        }
    }
}

public class MemoryLeakExample {
    public static void main(String[] args) {
        int seq = 0;

        Stack s = new Stack();

        for (int i = 0; i < 10; i++) {
            while (!s.isFull()) {
                s.push(seq++);
            }
            s.push(seq++);
            while (!s.isEmpty()) {
                s.pop();
            }
        }
    }
}
