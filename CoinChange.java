
public class CoinChange {
    // Time Complexity : O(n*sum)
    // Space Complexity : O(n*sum)
    public static int Find_Way(int[] coin, int sum) {
        int n = coin.length;
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }

        // i -> coins , j-> sum/changes
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                int val = coin[i - 1];
                if (val <= j) { // valid
                    int include = dp[i][j - val];
                    int exclude = dp[i - 1][j];
                    dp[i][j] = include + exclude;
                } else { // invalid
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        // System.out.println(dp[2][10]);
        return dp[n][sum];
    }


    
    // Optimized (1D DP) Code
    // Time Complexity : O(n*sum)
    // Space Complexity : O(sum)
    public static int Find_Way1(int[] coin, int sum) {

        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for (int i = 0; i < coin.length; i++) {
            for (int j = coin[i]; j <= sum; j++) {
                dp[j] += dp[j - coin[i]];
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        int[] coin = { 2, 5, 3, 6 };
        int sum = 10;
        System.out.println(Find_Way(coin, sum));
        System.out.println(Find_Way1(coin, sum)); // another approach for space reduce
    }
}
