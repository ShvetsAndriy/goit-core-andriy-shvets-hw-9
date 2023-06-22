package linkedlist;

public class MyListNode<T> {
    private T value;
    private MyListNode<T> previous;
    private MyListNode<T> next;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public MyListNode<T> getNext() {
        return next;
    }

    public void setNext(MyListNode<T> next) {
        this.next = next;
    }

    public MyListNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(MyListNode<T> previous) {
        this.previous = previous;
    }
}
