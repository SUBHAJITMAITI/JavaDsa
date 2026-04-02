import java.util.*;
import java.io.*;
//time complexity -O(m*n)
//space complexity -O(1)

public class prefixSumApproach {

    // time complexity -O(m*n)
    // space complexity -O(1)

    public static void prefixSumMatrix(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        // traversed the array row-wise to calculate the row-wise prefix sum
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j] += arr[i][j - 1];
            }
        }
        // traversed the array column-wise to calculate the column-wise prefix sum
        // final 2D array matrix
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] += arr[i - 1][j];
            }
        }
    }

    // time complexity -O(1)
    // space complexity -O(1)

    public static int sumRegion(int[][] arr, int r1, int c1, int r2, int c2) {

        int sum, up, left, repeat_region, result;
        sum = arr[r2][c2];
        up = (r1 > 0) ? arr[r1 - 1][c2] : 0;
        left = (c1 > 0) ? arr[r2][c1 - 1] : 0;
        repeat_region = (r1 > 0 && c1 > 0) ? arr[r1 - 1][c1 - 1] : 0;
        result = sum - up - left + repeat_region;

        return result;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a number of rows :");
        int m = sc.nextInt();
        System.out.println("enter a number of columns :");
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        System.out.println("enter the matrix element :");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                arr[i][j] = sc.nextInt();

            }
            // System.out.println();
        }
        int r1, c1, r2, c2;
        System.out.print("enter the value of r1 coordinate : ");
        r1 = sc.nextInt();
        System.out.print("enter the value of c1 coordinate : ");
        c1 = sc.nextInt();
        System.out.print("enter the value of r2 coordinate : ");
        r2 = sc.nextInt();
        System.out.print("enter the value of c2 coordinate : ");
        c2 = sc.nextInt();

        prefixSumMatrix(arr);

        for (var num : arr) {
            System.out.println(Arrays.toString(num));
        }

        int result = sumRegion(arr, r1, c1, r2, c2);
        System.out.println("sum of elements of given rectangle is : " + result);
        sc.close();

    }
}
