import java.util.*;

public class Threesum {
    public static List<List<Integer>> Three(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {

                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ArrayList<Integer> list = new ArrayList<>();

                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);

                        Collections.sort(list);
                        result.add(list);
                    }
                }
            }
        }

        // Remove duplicates
        result = new ArrayList<>(new LinkedHashSet<>(result));

        return result;
    }

    public static void main(String[] args) {
        int[] num = { -1, 0, 1, 2, -1, -4 };
        System.out.println(Three(num));
    }
}