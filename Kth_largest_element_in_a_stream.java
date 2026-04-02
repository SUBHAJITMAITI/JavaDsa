/*
---------------- Complexity Analysis ----------------
n = number of elements in stream
k = required kth largest

- Each insertion/removal in PriorityQueue (heap) → O(log k)
- For n elements → O(n log k) time
- Heap stores at most k elements → O(k) space
-----------------------------------------------------
*/
import java.util.PriorityQueue;

public class Kth_largest_element_in_a_stream {
        public static void main(String[] args) {
        int stream[] = { 10, 20, 11, 70, 50, 40, 100, 5 };
        int k = 3;

        // Min-heap to store k largest elements
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : stream) {
            // Step 1: Insert element if heap has less than k elements
            if (pq.size() < k) {
                pq.add(num);
            } 
            // Step 2: If new element is bigger than heap’s smallest, replace
            else if (num > pq.peek()) {
                pq.poll();  // remove smallest of k elements
                pq.add(num);
            }

            // Step 3: Print result
            if (pq.size() < k) {
                System.out.print("_ "); // not enough elements yet
            } else {
                System.out.print(pq.peek() + " "); // kth largest = min of heap
            }
        }
    }
}
