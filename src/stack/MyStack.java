package stack;

import java.util.StringJoiner;

public class MyStack<T> {

    /* LIFO */

    private static final int INIT_SIZE = 16;
    private Object[] data;
    private int top = -1;

    public MyStack() {
        data = new Object[INIT_SIZE];
    }

//    push(Object value) додає елемент в кінець
    public void push(T value) {
        resizeIfNeed();
        top++;
        data[top] = value;
    }

    private void resizeIfNeed() {
        if (top == data.length) {
            int newSize = data.length * 2;
            Object[] newData = new Object[newSize];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
    }

//    size() повертає розмір колекції
    public int size() {
        return top + 1;
    }

//    clear() очищає колекцію
    public void clear() {
        Object[] newData = new Object[INIT_SIZE];
        data = newData;
        top = -1;
    }

    private boolean isEmpty() {
        return (top < 0);
    }

//    peek() повертає перший елемент стеку
    public T peek() {
        if (!isEmpty()) {
            return (T) data[top];
        } else {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
    }

//    pop() повертає перший елемент стеку та видаляє його з колекції
    public T pop() {
        if (!isEmpty()) {
            return (T) data[top--];
        } else {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
    }

//    remove(int index) видаляє елемент за індексом
    public void remove(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Stack is empty");
        } else {
            if (index < 0 || index > top) {
                System.out.println("index is not in the list, enter a value from 1 to" + top + 1);
            } else {
                Object[] newData = new Object[top];
                System.arraycopy(data, 0, newData, 0, index);
                System.arraycopy(data, index+1, newData, index, top - index);
                data = newData;
                top--;
            }
        }
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner("->");
        for (int i = top; i >= 0; i--) {
            result.add(data[i].toString());
        }
        return "[" + result + "]";
    }

}
