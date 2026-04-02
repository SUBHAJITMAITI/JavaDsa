//Time Complexity : O(n × sum)
// Space complexity: O(n × sum)
public class CoinChange_usingMemoization {

    public static int Find_Way(int[] coin, int n, int sum, int[][] dp) {
        if (sum == 0) {
            return 1;

        }
        if (n == 0) {
            return 0;
        }
        if (dp[n][sum] != 0) {
            return dp[n][sum];
        }
        if (coin[n - 1] <= sum) {
            int include = Find_Way(coin,n, sum - coin[n - 1], dp);
            int exclude = Find_Way(coin, n - 1, sum, dp);
            dp[n][sum] = include + exclude;
            return dp[n][sum];

        } else {
            int exclude = Find_Way(coin, n - 1, sum, dp);
            dp[n][sum] = exclude;
            return dp[n][sum];
        }
    }

    public static void main(String[] args) {
        int[] coin = { 2, 5, 3, 6 };
        int sum = 10;
        int n = coin.length;
        int[][] dp = new int[n + 1][sum + 1];
        System.out.println(Find_Way(coin, coin.length, sum, dp));
    }
}
