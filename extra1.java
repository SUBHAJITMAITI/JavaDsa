import java.util.*;

public class extra1 {
//brute forse
    // time complexity => O(n^3 * log(numbers of unic triplates))
    //space complexity => 2*O(numbers of triplates)

    // public static List<List<Integer>> threesum(int[] arr) {
    // List<List<Integer>> num = new ArrayList<>();

    // for (int i = 0; i < arr.length; i++) {
    // for (int j = i + 1; j < arr.length; j++) {
    // for (int k = j + 1; k < arr.length; k++) {
    // if (arr[i] + arr[j] + arr[k] == 0) {
    // List<Integer> list = new ArrayList<>();
    // list.add(arr[i]);
    // list.add(arr[j]);
    // list.add(arr[k]);
    // Collections.sort(list);
    // num.add(list);
    // }
    // }
    // }

    // }
    // num = new ArrayList<List<Integer>>(new LinkedHashSet<List<Integer>>(num));
    // return num;

    // }
    // TC=0(n^3) & Sc=2*0(no: of triplet)
    // public static List<List<Integer>> threesum(int nums[]) {
    // int n = nums.length;
    // Set<List<Integer>> result = new HashSet<>();
    // for (int i = 0; i < n; i++) {
    // for (int j = i + 1; j < n; j++) {
    // for (int k = j + 1; k < n; k++) {
    // if (nums[i] + nums[j] + nums[k] == 0) {
    // List<Integer> triplts = Arrays.asList(nums[i], nums[j], nums[k]);
    // Collections.sort(triplts);
    // result.add(triplts);
    // }
    // }
    // }
    // }
    // return new ArrayList<>(result);
    // }

    // better

  // time complexity => O(n^2 *log(m))
    //space complexity => O(n) + 2*O(numbers of triplates)


    // public static List<List<Integer>> threesum(int[] nums) {
    // int n = nums.length;
    // Set<List<Integer>> result = new HashSet<>();
    // for (int i = 0; i < n; i++) {
    // Set<Integer> seen = new HashSet<>();
    // for (int j = i + 1; j < n; j++) {
    // int k = -nums[i] - nums[j];
    // if (seen.contains(k)) {
    // List<Integer> triplst = Arrays.asList(nums[i], nums[j], k);
    // Collections.sort(triplst);
    // result.add(triplst);
    // }
    // seen.add(nums[j]);
    // }
    // }
    // return new ArrayList<>(result);
    // }

    //optimal

    // time complexity => O(nlogn ) + O(n^2)

    //space complexity => O(numbers of unic triplates)

    public static List<List<Integer>> threesum(int[] nums) {
        List<List<Integer>> list = new ArrayList1<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }

            }

        }
        return list;
    }

    // public static List<List<Integer>> threesum(int[] nums) {
    // int n = nums.length;
    // List<List<Integer>> result = new ArrayList<>();
    // Arrays.sort(nums);
    // for (int i = 0; i < n; i++) {
    // if (i > 0 && nums[i] == nums[i - 1])
    // continue;
    // int j = i + 1;
    // int k = n - 1;
    // while (j < k) {
    // int sum = nums[i] + nums[j] + nums[k];

    // if (sum < 0) {
    // j++;
    // } else if (sum > 0) {
    // k--;
    // } else {
    // result.add(Arrays.asList(nums[i], nums[j], nums[k]));
    // j++;
    // k--;
    // while (j < k && nums[j] == nums[j - 1])
    // j++;
    // while (j < k && nums[k] == nums[k + 1])
    // k--;
    // }

    // }
    // }
    // return result;
    // }

    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, 3, -4 };
        System.out.println(threesum(arr));

    }
}
