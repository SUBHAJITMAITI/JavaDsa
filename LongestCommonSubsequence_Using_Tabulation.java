//Time Complexity=O(n×m)
//Space Complexity=O(n×m)
public class LongestCommonSubsequence_Using_Tabulation {
    public static int lcs(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }

        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                } else {
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);

                }
            }
        }

         // Step 2: Backtrack to find the actual LCS string
        StringBuilder s = new StringBuilder("");
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                s.append(str1.charAt(i - 1)); // Match found → part of LCS
                i--;
                j--;
            } else if (dp[i][j - 1] < dp[i - 1][j]) {
                i--;  // Move up
            } else {
                j--;  //// Move left
            }
        }

        // Since we built LCS in reverse order, reverse it
        s.reverse();
        System.out.println(s);
        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "abcdge";
        String str2 = "abedg"; // lcs ="abdg"; length = 4

        System.out.println(lcs(str1, str2));
    }
}
