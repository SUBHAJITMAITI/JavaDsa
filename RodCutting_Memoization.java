//✅ Time Complexity = O(n × rodLength)
//✅ Space Complexity = O(n × rodLength)

public class RodCutting_Memoization {
    public static int Find_MaxProfit(int[] length, int[] price, int n, int rodLength, int[][] dp) {

        if (n == 0 || rodLength == 0) {
            return 0;
        }
        if (dp[n][rodLength] != 0) {
            return dp[n][rodLength];
        }
        if (length[n - 1] <= rodLength) {
            int include = price[n - 1] + Find_MaxProfit(length, price, n, rodLength - length[n - 1], dp);
            int exclude = Find_MaxProfit(length, price, n - 1, rodLength, dp);
            dp[n][rodLength] = Math.max(include, exclude);
            return dp[n][rodLength];

        } else {
            int exclude = Find_MaxProfit(length, price, n - 1, rodLength, dp);
            dp[n][rodLength] = exclude;
            return dp[n][rodLength];
        }

    }

    public static void main(String[] args) {
        int[] length = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] price = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int rodLength = 8;
        int n = length.length;
        int[][] dp = new int[n + 1][rodLength + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < rodLength + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        System.out.println(Find_MaxProfit(length, price, n, rodLength, dp));
    }
}
