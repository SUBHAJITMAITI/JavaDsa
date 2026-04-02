// Time Complexity =O(n) + O(n log n) + O(n) = O(n log n)
// (sorting dominates)

// Space Complexity =O(n) (for pairSort + ArrayList + Timsort aux space)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthChainOfPairs {
    public static void main(String[] args) {
        int pairs[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };

        double pairSort[][] = new double[pairs.length][3];
        for (int i = 0; i < pairs.length; i++) {
            pairSort[i][0] = i;
            pairSort[i][1] = pairs[i][0];
            pairSort[i][2] = pairs[i][1];
        }
        int chainLeng = 0;
        Arrays.sort(pairSort, Comparator.comparingDouble(o -> o[2]));
        ArrayList<Integer> a = new ArrayList<>();
        a.add((int) pairSort[0][0]);

        chainLeng = 1;
        double chainEnd = pairSort[0][2];
        for (int i = 1; i < pairs.length; i++) {
            if (chainEnd < pairSort[i][1]) {
                chainLeng++;
                a.add((int) pairSort[i][0]);
                chainEnd = pairSort[i][2];
            }
        }
        System.out.println("max chain length : " + chainLeng);
        for (int i = 0; i < a.size(); i++) {
            System.out.print("chain" + a.get(i) + " ");
        }
    }

}
