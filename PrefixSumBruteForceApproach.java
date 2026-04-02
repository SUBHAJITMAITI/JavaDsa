//time complexity -O(m*n)
//space complexity -O(1)

import java.util.*;

public class PrefixSumBruteForceApproach {
    public static int findSumMatrix(int[][] arr, int r1, int c1, int r2, int c2) {
        int sum = 0;
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
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
        int sum = findSumMatrix(arr, r1, c1, r2, c2);
        System.out.println("sum of elements of given rectangle is : "+ sum);
        sc.close();
    }
}
