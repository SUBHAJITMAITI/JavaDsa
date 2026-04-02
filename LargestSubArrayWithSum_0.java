//Time Complexity: O(n)
//Space Complexity: O(n)

import java.util.HashMap;

public class LargestSubArrayWithSum_0 {
    public static void main(String[] args) { // O(n)
        int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
        // int arr[] = { 3, 4, 5 };
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        int length = 0;
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if (hm.containsKey(sum)) {
                length = Math.max(length, j - hm.get(sum));
            } else {
                hm.put(sum, j);
            }
        }
        System.out.println("largest subarray with sum as 0 => " + length);
    }
}
