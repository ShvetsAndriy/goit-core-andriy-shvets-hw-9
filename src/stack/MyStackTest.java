package stack;

import queue.MyQueue;

public class MyStackTest {
    public static void main(String[] args) {

        int elementNumber = 3;                      // елемент для тестування
        int elementIndex = elementNumber - 1;       // індекс елемента, що обробляється

        MyStack<String> stackString = new MyStack<>();
        System.out.println("stackString.size() = " + stackString.size() + "; stackString = " + stackString + " (before adding elements)");
        for (char letter = 'A'; letter <= ('A'+ 9); letter++) {
            stackString.push(Character.toString(letter));
        }
        System.out.println("stackString.size() = " + stackString.size() + "; stackString = " + stackString);
        System.out.println("stackString.peek(x) = " + stackString.peek());
        System.out.println("stackString.size() = " + stackString.size() + "; stackString = " + stackString + " (after peek)");
        System.out.println("stackString.pop(x) = " + stackString.pop());
        System.out.println("stackString.size() = " + stackString.size() + "; stackString = " + stackString + " (after pop)");
        System.out.println("stackString.remove(index) for elementNumber = " + elementNumber);
        stackString.remove(elementIndex);
        System.out.println("stackString.size() = " + stackString.size() + "; stackString = " + stackString + " (after remove)");
        stackString.clear();
        System.out.println("stackString.size() = " + stackString.size() + "; stackString = " + stackString + " (after cleanup)");

        System.out.println("----------------------------------------------------------------------------------------------------");

        MyStack<Integer> stackInteger = new MyStack<>();
        System.out.println("stackInteger.size() = " + stackInteger.size() + "; stackInteger = " + stackInteger + " (before adding elements)");
        for (int i= 10; i <= 100; i+=10) {
            stackInteger.push(i);
        }
        System.out.println("stackInteger.size() = " + stackInteger.size() + "; stackInteger = " + stackInteger);
        System.out.println("stackInteger.peek(x) = " + stackInteger.peek());
        System.out.println("stackInteger.size() = " + stackInteger.size() + "; stackInteger = " + stackInteger + " (after peek)");
        System.out.println("stackInteger.pop(x) = " + stackInteger.pop());
        System.out.println("stackInteger.size() = " + stackInteger.size() + "; stackInteger = " + stackInteger + " (after pop)");
        System.out.println("stackInteger.remove(index) for elementNumber = " + elementNumber);
        stackInteger.remove(elementIndex);
        System.out.println("stackInteger.size() = " + stackInteger.size() + "; stackInteger = " + stackInteger + " (after remove)");
        stackInteger.clear();
        System.out.println("stackInteger.size() = " + stackInteger.size() + "; stackInteger = " + stackInteger + " (after cleanup)");

    }
}
