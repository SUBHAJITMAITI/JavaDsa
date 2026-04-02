//Time Complexity= O(n)

import java.util.HashMap;
// import java.util.Set;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        // int[] nums = { 1, 2 };
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) { // O(n)
            // if (hm.containsKey(nums[i])) {
            // hm.put(nums[i], hm.get(nums[i]) + 1);
            // } else {
            // hm.put(nums[i], 1);
            // }

            // another
            // int val = hm.containsKey(nums[i]) ? hm.get(nums[i]) + 1 : 1;
            // hm.put(nums[i], val);

            // another
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        // Set<Integer> s = hm.keySet();

        for (Integer e : hm.keySet()) {
            if (hm.get(e) > n / 3) {
                System.out.print(e + " ");
            }
        }
    }
}
