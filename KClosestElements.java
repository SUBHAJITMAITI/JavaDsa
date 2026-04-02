//Time Complexity : O(n)
//Space Complexity : O(k)

import java.util.ArrayList;
import java.util.List;

public class KClosestElements {

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - 1;
        while (right - left >= k) {
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }
        List<Integer> l = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            l.add(arr[i]);
        }
        return l;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int k = 4;
        int x = 3;

        System.out.println(findClosestElements(arr, k, x)); // Output: [1, 2, 3, 4]
    }
}
