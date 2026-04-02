//Time Complexity: O(n)
//Space Complexity: O(k)
import java.util.*;
import java.util.LinkedList;

public class Reversing_the_first_K_elements_of_a_Queue {
    public static void reverse_k_element(Queue<Integer> q, int k) {
        int size = q.size();
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < k; i++) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        for (int i = 0; i < size - k; i++) {
            q.add(q.remove());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            q.add(i * 10);
        }
        int k = 5;
        reverse_k_element(q, k);
        while (!q.isEmpty()) {
            System.out.print(q.peek()+" ");
            q.remove();
        }
    }
}
