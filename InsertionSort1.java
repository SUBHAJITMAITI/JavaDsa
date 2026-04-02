//Time Complexity : O(n ^ 2)
//Space Complexity : O(1)
import java.util.Arrays;

public class InsertionSort1 {
    public static void insertionsort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int val =arr[i] ;
            while (j >= 0 && val < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = val;
        }

    }

    public static void main(String[] args) {
        int[] arr = { 20, 50, 10, 12, 45, 67, 90 };
        // function calling
        insertionsort(arr);
        System.out.println(" Sorted array is : " + Arrays.toString(arr));
    }
}
