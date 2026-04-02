//Time Complexity:
//Binary search runs on [max, sum] ⇒ O(log(sum - max))
//Each check (split function) = O(N)
//Total = O(N log(sum))
//Space Complexity:
//Uses only variables, no extra arrays ⇒ O(1)

public class SplitArrayLargestSum {

    public static boolean split(int[] arr, int k, int mid) {
        int subArray = 1;
        int total = 0;
        for (int ele : arr) {
            if (ele + total > mid) {
                subArray++;
                total = ele;
            } else {
                total += ele;
            }
        }

        return k >= subArray;
    }

    public static int splitArray(int[] arr, int k) {

        int result = 0;
        int max = 0;
        int totalSum = 0;
        for (int ele : arr) {
            max = Math.max(max, ele);
            totalSum += ele;

        }
        int low = max, high = totalSum;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (split(arr, k, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // int Array[] = { 1, 2, 3, 4 };
        // int k = 3;
        int Array[] = { 1, 1, 2 };
        int k = 2;
        int[] arr3 = { 7, 2, 5, 10, 8 };
        int k3 = 3;
        System.out.println(splitArray(arr3, k3));
        System.out.println(splitArray(Array, k));
    }
}
