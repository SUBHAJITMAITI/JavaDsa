//Time Complexity :O(n*m)
//Space  Complexity : O(n*m)
//LIS(arr) = LCS(arr, sorted(arr without duplicates))

import java.util.Arrays;
import java.util.HashSet;

public class LongestIncreasingSubsequence_Using_Memoization {

    public static int lcs(int arr1[], int arr2[], int n, int m, int dp[][]) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];

        }
        if (arr1[n - 1] == arr2[m - 1]) {
            dp[n][m] = lcs(arr1, arr2, n - 1, m - 1, dp) + 1;
            return dp[n][m];
        } else {
            int ans1 = lcs(arr1, arr2, n - 1, m, dp);
            int ans2 = lcs(arr1, arr2, n, m - 1, dp);
            dp[n][m] = Math.max(ans1, ans2);
            return dp[n][m];
        }
    }

    public static int lis(int arr1[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        int arr2[] = new int[set.size()];
        int i = 0;
        for (int ele : set) {
            arr2[i] = ele;
            i++;
        }
        Arrays.sort(arr2);
        int n = arr1.length;
        int m = arr2.length;
        int dp[][] = new int[n + 1][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return lcs(arr1, arr2, n, m, dp);
    }

    public static void main(String[] args) {
        int arr[] = { 50, 3, 10, 7, 40, 80 };
        System.out.println(lis(arr));
    }
}
