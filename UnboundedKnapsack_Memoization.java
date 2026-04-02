//Time Complexity = O(n × weight)
// Space Complexity= O(n × weight)

public class UnboundedKnapsack_Memoization {
    public static int find_max(int[] val, int[] wt, int n, int weight, int[][] dp) {
        if (n == 0 || weight == 0) {
            return 0;
        }
        if (dp[n][weight] != 0) {
            return dp[n][weight];
        }

        if (wt[n - 1] <= weight) {
            int incProfit = val[n - 1] + find_max(val, wt, n, weight - wt[n - 1], dp);
            int exclude = find_max(val, wt, n - 1, weight, dp);
            dp[n][weight] = Math.max(incProfit, exclude);
            return dp[n][weight];
        } else {
            dp[n][weight] = find_max(val, wt, n - 1, weight, dp);
            return dp[n][weight];
        }
    }

    public static void main(String[] args) {
        int[] val = { 10, 30, 20 };
        int[] wt = { 5, 10, 15 };
        int weight = 20;
        int n = val.length;
        int[][] dp = new int[n + 1][weight + 1];

        System.out.println(find_max(val, wt, n, weight, dp));
    }
}
