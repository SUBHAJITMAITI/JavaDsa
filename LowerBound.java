
//Modification of binary search
// Time complexity : O(logN)
//Space complexity : O(1)
import java.util.*;

public class LowerBound {
    // function definition
    public static int firstFindOccurence(int[] arr, int n) {
        int result = -1;
        int high = arr.length - 1;
        int low = 0;
        while (low <= high) {
            // to avoid overflow
            int mid = low + (high - low) / 2;
            if (arr[mid] == n) {
                result = mid;
                // traverse to the left side of an array
                high = mid - 1;
            } else if (arr[mid] < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // size of an element from the user
        System.out.print("Enter the number of element present in an array : ");
        int n = sc.nextInt();
        // array elements entered from the user
        System.out.print("Enter the array elements : ");

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // target element from the user
        System.out.print("Enter target element : ");
        int target = sc.nextInt();
        // Function calling
        int result = firstFindOccurence(arr, target);
        if (result == -1) {
            System.out.println("searched element is not found in an array ");
        } else {
            System.out.println("searched element is  found in an array at the index  : " + result);
        }

    }
}
