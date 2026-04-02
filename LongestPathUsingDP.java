// Time Complexity: O(N×M)
//Space complexity: O(N×M)
public class LongestPathUsingDP {

    public static int findpath(int M[][]) {
        int n = M.length;
        int m = M[0].length;
        int dp[][] = new int[n][m];
        // Fill from bottom-right to top-left
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = 1; // minimum path length
                // move right
                if (j + 1 < m && M[i][j + 1] > M[i][j]) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i][j + 1]);
                }
                // move down
                if (i + 1 < n && M[i + 1][j] > M[i][j]) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i + 1][j]);
                }
            }

        }

        return dp[0][0];// starting from (0,0)

    }

    public static void main(String[] args) {

        int m[][] = { { 1, 2, 3, 4 },
                { 2, 2, 3, 4 },
                { 3, 2, 3, 4 },
                { 4, 5, 6, 7 } };
        // int m[][] = { { 1, 2 },
        // { 3, 4 } };
        System.out.println(findpath(m));

    }
}
