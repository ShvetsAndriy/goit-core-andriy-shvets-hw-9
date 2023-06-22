package queue;

import arraylist.MyArrayList;

public class MyQueueTest {
    public static void main(String[] args) {

        MyQueue<String> queueString = new MyQueue<>();
        System.out.println("queueString.size() = " + queueString.size() + "; queueString = " + queueString + " (before adding elements)");
        for (char letter = 'A'; letter <= ('A'+ 9); letter++) {
            queueString.add(Character.toString(letter));
        }
        System.out.println("queueString.size() = " + queueString.size() + "; queueString = " + queueString);
        System.out.println("queueString.peek(x) = " + queueString.peek());
        System.out.println("queueString.size() = " + queueString.size() + "; queueString = " + queueString + " (after peek)");
        System.out.println("queueString.poll(x) = " + queueString.poll());
        System.out.println("queueString.size() = " + queueString.size() + "; queueString = " + queueString + " (after poll)");
        queueString.clear();
        System.out.println("queueString.size() = " + queueString.size() + "; queueString = " + queueString + " (after cleanup)");

        System.out.println("----------------------------------------------------------------------------------------------------");

        MyQueue<Integer> queueInteger = new MyQueue<>();
        System.out.println("queueInteger.size() = " + queueInteger.size() + "; queueInteger = " + queueInteger + " (before adding elements)");
        for (int i= 10; i <= 100; i+=10) {
            queueInteger.add(i);
        }
        System.out.println("queueInteger.size() = " + queueInteger.size() + "; queueInteger = " + queueInteger);
        System.out.println("queueInteger.peek(x) = " + queueInteger.peek());
        System.out.println("queueInteger.size() = " + queueInteger.size() + "; queueInteger = " + queueInteger + " (after peek)");
        System.out.println("queueInteger.poll(x) = " + queueInteger.poll());
        System.out.println("queueInteger.size() = " + queueInteger.size() + "; queueInteger = " + queueInteger + " (after poll)");
        queueInteger.clear();
        System.out.println("queueInteger.size() = " + queueInteger.size() + "; queueInteger = " + queueInteger + " (after cleanup)");

    }
}
