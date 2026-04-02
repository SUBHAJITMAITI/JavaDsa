//Time Complexity : O(n^2)
//Space Complexity : O(1)
import java.util.Arrays;

public class selectionSort {
    public static void selectionsort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            //min_idx is taking the index  of minimum element at every iteration
            int min_idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min_idx] > arr[j]) {
                    min_idx = j;
                }
            }
            if (i != min_idx) {
                //swap between arr[min_idx] and arr[i]
                int temp = arr[min_idx];
                arr[min_idx] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 20, 50, 10, 12, 45, 67, 90 };
        // function calling
        selectionsort(arr);
        System.out.println(" Sorted array is : " + Arrays.toString(arr));
    }
}
