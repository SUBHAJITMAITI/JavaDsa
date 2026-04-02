//Time Complexity: O(n)
//Space Complexity: O(n)

import java.util.HashMap;

public class TwoSumUsingHashMap {
    public static int[] Twosum(int arr[], int target) {

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];
            if (hm.containsKey(diff)) {
                return new int[] { hm.get(diff), i };
            } else {
                hm.put(arr[i], i);
            }
        }
        return new int[] { 0, 0 };
    }

    public static void main(String[] args) {
        int []arr = { 2, 7, 11, 15 };
        int target = 9;
        int arr1[] = Twosum(arr, target);
        System.out.println(arr1[0] + "," + arr1[1]);

    }
}
