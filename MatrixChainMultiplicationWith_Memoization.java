//Time complexity : O(n^2)
import java.util.Arrays;

public class MatrixChainMultiplicationWith_Memoization {
    public static int mcm(int arr[], int i, int j, int[][] dp) {
        if (i == j) { // single matrix case
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int cost1 = mcm(arr, i, k, dp);// Ai...Ak =>arr[i-1] X arr[k]
            int cost2 = mcm(arr, k + 1, j, dp); // Ak+1...Aj =>arr[k] X arr[j]
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            int totalcost = cost1 + cost2 + cost3;
            ans = Math.min(ans, totalcost);
        }
       
        return  dp[i][j] = ans; // mincost
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 3 }; // n=5
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(mcm(arr, 1, n - 1, dp));
    }
}
