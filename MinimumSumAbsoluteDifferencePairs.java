//time complexity : O(nlogn)
//Space: O(1)
import java.util.Arrays;

public class MinimumSumAbsoluteDifferencePairs {
    public static void main(String[] args) {
        // int[] a = { 1, 2, 3 };
        // int[] b = { 2, 1, 3 };
        int[] a = { 4, 1, 8, 7 };
        int[] b = { 2, 3, 6, 5 };
        Arrays.sort(a); // O(nlogn)
        Arrays.sort(b);  // O(nlogn)
        int minDiff = 0;
        for (int i = 0; i < a.length; i++) {
            minDiff += Math.abs(a[i] - b[i]);
        }
        System.out.println("min absolute diff of pairs = " + minDiff);
    }
}
