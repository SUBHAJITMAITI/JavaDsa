//Time Complexity = O(n) + O(n log n) + O(n) = O(n log n)
//(sorting dominates)

//Space Complexity =O(n) (for ratio array + Timsort extra space)
import java.util.Arrays;
import java.util.Comparator;

public class fractional_knapsack {
    public static void main(String[] args) {
        int val[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };
        int w = 50;

        double[][] ratio = new double[weight.length][2];
        // 0th col =>index; //1st col =>ratio

        for (int i = 0; i < weight.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double) weight[i];
        }
        Arrays.sort(ratio, Comparator.comparingDouble((double[] o) -> o[1]).reversed()); // Descending order
        int capacity = w;
        int finalVal = 0;
        for (int i = 0; i < weight.length; i++) {
            int idx = (int) ratio[i][0];
            if (weight[idx] <= capacity) { // include full item
                capacity -= weight[i];
                finalVal += val[i];
            } else {
                // include fractional item
                finalVal += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }
        System.out.println("final value is : " + finalVal);
    }
}
