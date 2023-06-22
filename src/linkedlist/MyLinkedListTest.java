package linkedlist;

import arraylist.MyArrayList;

public class MyLinkedListTest {
    public static void main(String[] args) {
        int elementNumber = 3;                      // елемент для тестування
        int elementIndex = elementNumber - 1;       // індекс елемента, що обробляється

        MyLinkedList<String> listString = new MyLinkedList<>();
        System.out.println("listString.size() = " + listString.size() + "; listString = " + listString + " (before adding elements)");
        for (char letter = 'A'; letter <= 'Z'; letter++) {
            listString.add(Character.toString(letter));
        }
        System.out.println("listString.size() = " + listString.size() + "; listString = " + listString);
        System.out.println("listString.get(x) = " + listString.get(elementIndex) + " (" + elementNumber + " element)");
        listString.remove(elementIndex);
        System.out.println("listString.size() = " + listString.size() + "; listString = " + listString + " (after removing)");
        listString.clear();
        System.out.println("listString.size() = " + listString.size() + "; listString = " + listString + " (after cleanup)");

        System.out.println("----------------------------------------------------------------------------------------------------");

        MyLinkedList<Integer> listInteger = new MyLinkedList<>();
        System.out.println("listInteger.size() = " + listInteger.size() + "; listInteger = " + listInteger + " (before adding elements)");
        for (int i= 10; i <= 100; i+=10) {
            listInteger.add(i);
        }
        System.out.println("listInteger.size() = " + listInteger.size() + "; listInteger = " + listInteger);
        System.out.println("listInteger.get(x) = " + listInteger.get(elementIndex) + " (" + elementNumber + " element)");
        listInteger.remove(elementIndex);
        System.out.println("listInteger.size() = " + listInteger.size() + "; listInteger = " + listInteger + " (after removing)");
        listInteger.clear();
        System.out.println("listInteger.size() = " + listInteger.size() + "; listInteger = " + listInteger + " (after cleanup)");

    }
}
