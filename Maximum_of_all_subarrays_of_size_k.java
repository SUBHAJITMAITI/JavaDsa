// Sliding Window Maximum
//Time Complexity  : O(n)
//Space Complexity: O(k)
import java.util.*;
import java.util.LinkedList;

public class Maximum_of_all_subarrays_of_size_k {
    public static void Maximum_subArray(int arr[], int k) {
        Deque<Integer> s = new LinkedList<>();
        int i = 0;
        for (i = 0; i < k; i++) {
            while (!s.isEmpty() && arr[s.peekLast()] <= arr[i]) {
                s.removeLast();
            }
            s.addLast(i);
        }

        for (; i < arr.length; i++) {

            System.out.print(arr[s.peekFirst()] + "  ");
            if (!s.isEmpty() && s.peekFirst() <= i - k) {
                s.removeFirst();
            }
            while (!s.isEmpty() && arr[s.peekLast()] <= arr[i]) {
                s.removeLast();
            }
            s.addLast(i);

        }
        System.out.println(arr[s.peekFirst()]);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
        int k = 3;
        Maximum_subArray(arr, k);
    }
}
