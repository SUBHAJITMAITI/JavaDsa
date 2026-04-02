//O(n log n) + O(n log n) = O(n log n)
// Time Complexity: O(n log n)

//Space Complexity: O(n)

import java.util.*;

public class Connect_n_ropes_with_minimum_cost {

    public static void connet(int[] arr) {
        int total = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(); // PriorityQueue stores at most n elements space complexity :
                                                          // O(n)
        // all rope length in heap
        for (int i = 0; i < arr.length; i++) { // n insertions → O(n log n)(each insertion in PriorityQueue takes O(log
                                               // n)).
            q.add(arr[i]);
        }
        // while heap contain more than one element
        while (q.size() > 1) { // Together = O(3 log n) ≈ O(log n) per step We do this (n - 1) times (until one
                               // rope left)
            int first = q.poll();// first min // tc:(log n)
            int second = q.poll();// second min // tc:(log n)
            int val = first + second;
            total += val;
            q.add(val); // new rope add in heap // tc:(log n)
        }
        System.out.println(total);
    }

    public static void main(String[] args) {
        int[] arr = { 4, 3, 2, 6 };
        connet(arr);
        int[] arr1 = { 1, 2, 3 };
        connet(arr1);
    }
}
