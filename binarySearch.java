//time complexity - O(logN)
//space complexity- O (1)

import java.util.Scanner;

public class binarySearch {
    public static int search(int[] arr, int n) {
        int num = 0;
        int high = arr.length - 1;
        int low = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == n) {
                return mid;
            } else if (arr[mid] < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return num;
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
        int num = sc.nextInt();
        // Function calling of binarySearch
        int result = search(arr, num);
        if (result == 0) {
            System.out.println("searched element is not found in an array ");
        } else {
            System.out.println("searched element is  found in an array at the location  : " + result);
        }

    }
}
