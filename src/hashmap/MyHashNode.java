package hashmap;

import java.util.Objects;

public class MyHashNode<K,V> {
    private int hash;
    private final K key;
    private V value;
    private MyHashNode<K,V> next;

    public MyHashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public K getKey() {
        return key;
    }

    public MyHashNode<K,V> getNext() {
        return next;
    }

    public void setNext(MyHashNode<K,V> next) {
        this.next = next;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public int getHash() {
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyHashNode<?,?> that = (MyHashNode<?,?>) o;
        return Objects.equals(key, that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    @Override
    public String toString() {
        return "[" + key + ", " + value + "]";
    }
}
