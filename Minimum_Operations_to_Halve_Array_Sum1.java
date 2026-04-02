import java.util.Comparator;
import java.util.PriorityQueue;

public class Minimum_Operations_to_Halve_Array_Sum1 {
    public static int findcount(int[] arr) {

        double total = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            pq.add((double) arr[i]);
            total += arr[i];
        }
        int count = 0;

        double target = total / 2;
        double CurrentTotal = total;
        while (target < CurrentTotal) {
            Double ele = pq.poll();
            double half = ele / 2.0;
            CurrentTotal -= (ele - half);
            pq.add(half);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 5, 8, 19 };
        System.out.println(findcount(arr));
    }
}
