import java.util.*;
import java.util.LinkedList;

public class QueueUsingDeque {
    public static class Queue {
        static Deque<Integer> q = new LinkedList<>();

        public static void add(int data) {
            q.addLast(data);
        }

        public static int remove() {
            return q.removeFirst();
        }

        public static int peek() {
            return q.getFirst();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println("peek : " + q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());

    }
}
