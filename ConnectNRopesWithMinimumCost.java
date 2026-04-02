//Time Complexity: O(n log n)
//Space Complexity: O(n)

import java.util.PriorityQueue;

public class ConnectNRopesWithMinimumCost {
    public static void main(String[] args) {
        int ropes[] = { 4, 3, 2, 6 };
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cost = 0;
        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }
        while (pq.size() > 1) {
            int min1 = pq.remove();
            int min2 = pq.remove();
            int total = min1 + min2;
            cost += total;

            pq.add(total);

        }
        System.out.println("cost of connecting n ropes = " + cost);
    }
}
