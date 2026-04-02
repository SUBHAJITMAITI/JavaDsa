//Time: O((n+m)logn), where m = number of operations (halving steps).
//Space:  O(n)

import java.util.Comparator;
import java.util.PriorityQueue;

public class Minimum_Operations_to_Halve_Array_Sum {

    public static int totalOperation(int[] arr) {
        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
        double total = 0;
        for (int i = 0; i < arr.length; i++) { //O(n log n)
            pq.add((double) arr[i]);
            total += arr[i];
        }
        int count = 0;
        double currtotal = total;
        double target = total / 2.0;
        while (currtotal > target) {  //O(m log n)
            count++;
            double ele = pq.poll();
            double half = ele / 2.0;
            currtotal -= (ele - half);
            pq.add(half);

        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 5, 8, 19 };
        int count = totalOperation(arr);
        System.out.println(count);
    }
}
