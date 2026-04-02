import java.util.*;
import java.util.LinkedList;

public class sliding {
    public static void maxFind(int[] arr, int k) {
        Deque<Integer> s = new LinkedList<>();
        int i;
        for (i = 0; i < k; i++) {
            while (!s.isEmpty() && arr[i] >= arr[s.peekLast()]) {
                s.removeLast();
            }
            s.addLast(i);
        }
        for (; i < arr.length; i++) {
            System.out.print(arr[s.peek()] + " ");
            if (!s.isEmpty() && s.peek() <= i - k) {
                s.removeFirst();
            }
            while (!s.isEmpty() && arr[i] >= arr[s.peekLast()]) {
                s.removeLast();
            }
            s.addLast(i);
        }
        System.out.print(arr[s.peek()]);
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 7, 10, 12, 15, 25, 17 };
        maxFind(arr, 3);
    }
}
