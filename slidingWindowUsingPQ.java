//Time Complexity: O(klogk) + O(nlogn) = O(nlogn)
//Space Complexity: O(n)  (output array = O(n))

import java.util.PriorityQueue;

public class slidingWindowUsingPQ {
    public static class pair {
        int value;
        int idx;

        pair(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int result[] = new int[arr.length - k + 1];

        PriorityQueue<pair> pq = new PriorityQueue<>((v1, v2) -> v2.value - v1.value);
        // first window
        for (int i = 0; i < k; i++) { // O(k log k).
            pq.add(new pair(arr[i], i));
        }
        result[0] = pq.peek().value;
        for (int i = k; i < arr.length; i++) { // O((n - k) log n) ≈ O(n log n).
            while (pq.size() > 1 && pq.peek().idx <= i - k) {
                pq.remove();
            }
            pq.add(new pair(arr[i], i));
            result[i - k + 1] = pq.peek().value;
        }
        // print result
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
