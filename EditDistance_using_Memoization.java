public class EditDistance_using_Memoization {
    public static int edit_distance(String word1, String word2, int n, int m, int[][] dp) {
        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        if (word1.charAt(n - 1) == word2.charAt(m - 1)) {
            dp[n][m] = edit_distance(word1, word2, n - 1, m - 1, dp);
            return dp[n][m];
        } else {
            // Perform 3 possible operations:
            // 1. Delete
            int ans1 = edit_distance(word1, word2, n - 1, m, dp);
            // 2. Insert
            int ans2 = edit_distance(word1, word2, n, m - 1, dp);
            // 3. Replace
            int ans3 = edit_distance(word1, word2, n - 1, m - 1, dp);
            dp[n][m] = Math.min(Math.min(ans1, ans2), ans3) + 1;
            return dp[n][m];
        }
    }

    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) {
            java.util.Arrays.fill(row, -1);
        }
        System.out.println(edit_distance(word1, word2, word1.length(), word2.length(), dp));
    }
}
