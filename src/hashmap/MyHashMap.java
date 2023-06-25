package hashmap;

import java.util.Objects;
import java.util.StringJoiner;

public class MyHashMap<K,V> {

    private static final int COUNT_OF_BUCKETS = 16;
    private MyHashNode[] table;
    private int sizeOfCollection;

    public MyHashMap() {
        table = new MyHashNode[COUNT_OF_BUCKETS];
    }

    int hash(K key) {
        return Objects.hash(key);
    }

    static int indexOfBuckets(int hash, int length)
    {
        return hash & (length - 1);
    }

//    put(Object key, Object value) додає пару ключ + значення
    public void put(K key, V value) {
        int indexBucket;
        int nodeHash = hash(key);
        boolean keyExists = false;
        boolean endOfList = false;
        MyHashNode<K,V> newNode = new MyHashNode<>(key, value);
        newNode.setHash(nodeHash);
        indexBucket = indexOfBuckets(nodeHash , COUNT_OF_BUCKETS);
        if (table[indexBucket] == null) {
            table[indexBucket] = newNode;
            newNode.setNext(null);
            sizeOfCollection++;
        } else {
            MyHashNode listNode = table[indexBucket];
            do {
                if (listNode.getNext() == null) {
                    endOfList = true;
                }
                if (newNode.getHash() == listNode.getHash() && (newNode.equals(listNode))) {
                    listNode.setValue(newNode.getValue());
                    keyExists = true;
                    break;
                } else if (!endOfList) {
                    listNode = listNode.getNext();
                }
            } while (!endOfList);
            if (!keyExists) {
                listNode.setNext(newNode);
                sizeOfCollection++;
           }
        }
    }

//    get(Object key) повертає значення (Object value) за ключем
    public V get(K key) {
        int indexBucket;
        int nodeHash = hash(key);
        boolean endOfList = false;
        indexBucket = indexOfBuckets(nodeHash , COUNT_OF_BUCKETS);
        if (table[indexBucket] == null) {
            return null;
        }
        MyHashNode listNode = table[indexBucket];
        do {
            if (listNode.getNext() == null) {
                endOfList = true;
            }
            if (listNode.getHash() == nodeHash && listNode.getKey() == key) {
                return (V) listNode.getValue();
            } else if (!endOfList) {
                listNode = listNode.getNext();
            }
        } while (!endOfList);
        return null;
    }

//    remove(Object key) видаляє пару за ключем
    public void remove(K key) {
        int indexBucket;
        int nodeHash = hash(key);
        boolean endOfList = false;
        boolean keyExists = false;
        indexBucket = indexOfBuckets(nodeHash , COUNT_OF_BUCKETS);
        if (table[indexBucket] == null) {
            System.out.println("Map is empty! Nothing to remove!");
        } else {
            MyHashNode listNode = table[indexBucket];           // head of List
            MyHashNode previousNode = table[indexBucket];
            do {
                if (listNode.getNext() == null) {
                    endOfList = true;
                }
                if (listNode.getHash() == nodeHash && listNode.getKey() == key) {
                    if (listNode.getNext() == null) {
                        if (listNode.getHash() == previousNode.getHash() && listNode.equals(previousNode)) {
                            table[indexBucket] = null;
                            sizeOfCollection--;
                        } else {
                            previousNode.setNext(null);
                            sizeOfCollection--;
                        }
                    } else {
                        previousNode.setNext(listNode.getNext());
                        sizeOfCollection--;
                    }
                    keyExists = true;
                    break;
                } else if (!endOfList) {
                    if (!(listNode.getHash() == previousNode.getHash() && listNode.equals(previousNode))) {
                        previousNode = previousNode.getNext();
                    }
                    listNode = listNode.getNext();
                }
            } while (!endOfList);
        }
        if (!keyExists) {
            System.out.println("We don't have this Key - \"" + key + "\" in a map!");
        }
    }

//    size() повертає розмір колекції
    public int size() {
        return sizeOfCollection;
    }

//    clear() очищає колекцію
    public void clear() {
        table = new MyHashNode[COUNT_OF_BUCKETS];
        sizeOfCollection = 0;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner("");
        for (int i = 0; i < COUNT_OF_BUCKETS; i++) {
            if (table[i] != null) {
                result.add("[bucket = " + i + " : ");
                boolean endOfList = false;
                MyHashNode listNode = table[i];           // head of List
                do {
                    result.add(listNode.toString());
                    if (listNode.getNext() != null) {
                        listNode = listNode.getNext();
                    } else {
                        endOfList = true;
                    }
                } while (!endOfList);
                result.add("]");
                result.add("\n");
            }
        }
        return result.toString();
    }
}
