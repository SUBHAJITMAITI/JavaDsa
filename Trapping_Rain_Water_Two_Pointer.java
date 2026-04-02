//✅ Time Complexity: O(n)
//✅ Space Complexity: O(1)
public class Trapping_Rain_Water_Two_Pointer {
    public static int maxWater(int[] arr) {
        int maxWater = 0;

        int rightmax = 0;
        int leftmax = 0;
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            if (arr[low] < arr[high]) {
                if (leftmax <= arr[low]) {
                    leftmax = arr[low];
                } else {
                    maxWater += leftmax - arr[low];
                }
                low++;
            }

            else {
                if (rightmax <= arr[high]) {
                    rightmax = arr[high];
                } else {
                    maxWater += rightmax - arr[high];
                }
                high--;
            }

        }
        return maxWater;
    }

    public static void main(String[] args) {
        int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.print(maxWater(arr));
    }
}
