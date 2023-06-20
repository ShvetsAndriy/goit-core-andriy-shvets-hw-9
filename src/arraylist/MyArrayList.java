package arraylist;

import java.util.StringJoiner;

public class MyArrayList<T> {

    private static final int INIT_SIZE = 16;
    private Object[] data;
    private int index = 0;

    public MyArrayList() {
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

//    get(int index) повертає елемент за індексом
    public T get(int i) {
        if (i < 0 || i > index - 1) {
            System.out.println("index is not in the list, enter a value from 1 to" + index);
            return null;
        }
        return (T) data[i];
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

//    remove(int index) видаляє елемент із вказаним індексом
    public void remove(int i) {
        if (i < 0 || i > index - 1) {
            System.out.println("index is not in the list, enter a value from 1 to" + index);
        } else {
            Object[] newData = new Object[data.length];
            System.arraycopy(data, 0, newData, 0, i);
            System.arraycopy(data, i+1, newData, i, data.length - i -1);
            data = newData;
            index--;
        }
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        for (int i = 0; i < index; i++) {
            result.add(data[i].toString());
        }
        return "[" + result + "]";
    }

}
