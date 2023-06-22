package linkedlist;

import java.util.StringJoiner;

public class MyLinkedList<T> {

    private MyListNode<T> head;

//    add(Object value) додає елемент в кінець
    public void add(T item) {
        MyListNode<T> node = new MyListNode<>();
        node.setValue(item);
        if (head == null) {
            head = node;
        } else {
            MyListNode<T> last = head;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(node);
            node.setPrevious(last);
        }
    }

//    size() повертає розмір колекції
    public int size() {
        if (head == null) {
            return 0;
        }
        int count = 1;
        MyListNode<T> last = head;
        while (last.getNext() != null) {
            last = last.getNext();
            count++;
        }
        return count;
    }

//    get(int index) повертає елемент за індексом
    public T get(int index) {
        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        if (index < 0) {
            throw new IndexOutOfBoundsException("You must choose element for getting from 1 to " + size());
        }
        MyListNode<T> search = head;
        for (int i = 0; i < index; i++) {
            search = search.getNext();
            if (search == null) {
                throw new IndexOutOfBoundsException("Invalid index: " + index + ", Size: " + size());
            }
        }
        return search.getValue();
    }

//    remove(int index) видаляє елемент із вказаним індексом
    public void remove(int index) {
        int size = size();
        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        if (index < 0) {
            throw new IndexOutOfBoundsException("Too low, you must choose element for deleting from 1 to " + size);
        }
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("Too lot, you must choose element for deleting from 1 to " + size);
        }
        MyListNode<T> node = head;
        MyListNode<T> previous = null;
        MyListNode<T> next = null;
        if (index == 0) {
            next = node.getNext();
            next.setPrevious(null);
            head = next;
            node = null;
        } else {
            int i = 1;
            while (i <= index) {
                node = node.getNext();
                i++;
            }
            previous = node.getPrevious();
            if (i == size) {
                previous.setNext(null);
            } else {
                next = node.getNext();
                next.setPrevious(previous);
                previous.setNext(next);
            }
            node = null;
        }
    }

//    clear() очищає колекцію
    public void clear() {
        head = null;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        int size = size();
        MyListNode<T> print = head;
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                result.add(print.getValue().toString());
                print = print.getNext();
            }
        } else {
            result.add(" ");
        }
        return "[" + result + "]";
    }

}
