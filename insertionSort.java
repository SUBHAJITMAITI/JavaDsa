//Time Complexity : O(n ^ 2)
//Space Complexity : O(1)
import java.util.Arrays;

public class insertionSort {
    // implementation of insertion sort
    public static void insertionsort(int []arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                // swap the elments between arr[j] and arr[j-1]
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }

        }

    }

    public static void main(String[] args) {
        int []arr = { 20, 50, 10, 12, 45, 67, 90 };
        // function calling
        insertionsort(arr);
        System.out.println(" Sorted array is : "+Arrays.toString(arr));
    }
}
