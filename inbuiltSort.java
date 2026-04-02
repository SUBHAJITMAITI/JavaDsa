import java.util.Arrays;
import java.util.Collections;

public class inbuiltSort {
    public static void PrintArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void PrintArr(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = { 5, 4, 1, 3, 2 };
        // Arrays.sort(arr);
        PrintArr(arr);
        Arrays.sort(arr,0,3);
        PrintArr(arr);
        Integer [] arr1 = { 5, 4, 1, 3, 2 };
        // Arrays.sort(arr1,Collections.reverseOrder());
        Arrays.sort(arr1,0,3,Collections.reverseOrder());
        PrintArr(arr1);

    }
}
