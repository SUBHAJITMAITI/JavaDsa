//push means add and pop means remove
import java.util.Stack;

public class QueueUsingTwoStack {

    // 1 Approach A — Push is O(n), Pop is O(1)

    // public static class Queue {
    // public static Stack<Integer> s1 = new Stack<>();
    // public static Stack<Integer> s2 = new Stack<>();

    // public static boolean isEmpty() {
    // return s1.isEmpty();
    // }

    // public static void add(int data) {
    // while (!s1.isEmpty()) {
    // s2.push(s1.pop());
    // }
    // s1.add(data);

    // while (!s2.isEmpty()) {
    // s1.push(s2.pop());
    // }
    // }

    // public static int remove() {
    // if (s1.isEmpty()) {
    // System.out.println("queue is empty");
    // return -1;
    // }
    // return s1.pop();
    // }

    // 2 Approach B — Push is O(1), Pop is O(n)
    public static class Queue {
        public static Stack<Integer> s1 = new Stack<>();
        public static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        public static void add(int data) {
            s1.push(data);
        }

        public static int remove() {
            if (s1.isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            while (s1.size() > 1) {
                s2.push(s1.pop());
            }
            int front = s1.pop();
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
           
            return front;
        }

        public static int peek() {
            if (s1.isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
             while (s1.size() > 1) {
                s2.push(s1.pop());
            }
            int front = s1.peek();
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            return front;
        }

    }

     // 3 Approach B — Push is O(1), Pop is O(n)

    // public static class Queue {
    // public static Stack<Integer> s1 = new Stack<>();
    // public static Stack<Integer> s2 = new Stack<>();

    // public static boolean isEmpty() {
    // return s2.isEmpty() && s1.isEmpty();
    // }

    // public static void add(int data) {
    // s1.push(data);
    // }

    // public static int remove() {
    // if (isEmpty()) {
    // System.out.println("queue is empty");
    // return -1;
    // } else if (s2.isEmpty()) {
    // while (!s1.isEmpty()) {
    // s2.push(s1.pop());
    // }
    // }

    // return s2.pop();

    // }

    // public static int peek() {
    // if (isEmpty()) {
    // System.out.println("queue is empty");
    // return -1;
    // } else if (s2.isEmpty()) {
    // while (!s1.isEmpty()) {
    // s2.push(s1.pop());
    // }
    // }
    // return s2.peek();
    // }

    // }

    public static void main(String[] args) {

        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }

    }
}
