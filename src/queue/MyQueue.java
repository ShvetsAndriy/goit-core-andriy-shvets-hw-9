package queue;

import java.util.StringJoiner;

public class MyQueue<T> {

    /* FIFO */

    private static final int INIT_SIZE = 16;
    private Object[] data;
    private int index = 0;

    public MyQueue() {
        data = new Object[INIT_SIZE];
    }

//    add(Object value) додає елемент в кінець
    public void add(T value) {
        resizeIfNeed();
        data[index] = value;
        index++;
    }

    private void resizeIfNeed() {
        if (index == data.length) {
            int newSize = data.length * 2;
            Object[] newData = new Object[newSize];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
    }

//    size() повертає розмір колекції
    public int size() {
        return index;
    }

//    clear() очищає колекцію
    public void clear() {
        Object[] newData = new Object[INIT_SIZE];
        data = newData;
        index = 0;
    }

    private boolean isEmpty() {
        if (index == 0) {
            return true;
        } else {
            return false;
        }
    }

//    peek() повертає перший елемент з черги
    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return (T) data[0];
        }
    }

//    poll() повертає перший елемент з черги і видаляє його з колекції
    public T poll() {
        if (isEmpty()) {
            return null;
        } else {
            Object[] first = new Object[1];
            first[0] = data[0];
            Object[] newData = new Object[data.length];
            System.arraycopy(data, 1, newData, 0, data.length - 1 - 1);
            data = newData;
            index--;
            return (T) first[0];
        }
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner("<-");
        for (int i = 0; i < index; i++) {
            result.add(data[i].toString());
        }
        return "[" + result + "]";
    }

}
