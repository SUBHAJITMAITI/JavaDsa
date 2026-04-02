import java.util.*;
import java.util.LinkedList;

public class StackUsingDeque {
    public static class Stack {
        static Deque<Integer> q = new LinkedList<>();

        public static void push(int data) {
            q.addLast(data);
        }

        public static int pop() {
            return q.removeLast();
        }

        public static int peek() {
            return q.getLast();
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("peek : " + s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

    }
}
