public class EditDistance_using_Tabulation {
    // Time Complexity: O(n × m)
    // Space Complexity: O(n × m)
    public static int edit_distance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                if (j == 0) {
                    dp[i][j] = i;
                }
            }
        }

        // bottom up
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) { // same
                    dp[i][j] = dp[i - 1][j - 1];

                } else { // diff
                    int add = dp[i][j - 1] + 1;
                    int del = dp[i - 1][j] + 1;
                    int rep = dp[i - 1][j - 1] + 1;
                    dp[i][j] = Math.min(Math.min(add, del), rep);
                }
            }
        }
        return dp[n][m];
    }

    // optimized
    // Space Optimization O(n) //Time complexity : O(n*m)
    public static int edit_distance1(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int prev[] = new int[m + 1];
        int curr[] = new int[m + 1];
        for (int i = 0; i < m + 1; i++) {
            prev[i] = i;
        }

        // bottom up
        for (int i = 1; i < n + 1; i++) {
            curr[0] = i;
            for (int j = 1; j < m + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = prev[i - 1];
                } else {
                    int add = curr[j - 1] + 1;
                    int del = prev[j] + 1;
                    int rep = prev[j - 1] + 1;
                    curr[j] = Math.min(add, Math.min(del, rep));
                }
            }
            prev = curr.clone();
        }
        return prev[m];
    }

    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(edit_distance(word1, word2));
        System.out.println(edit_distance1(word1, word2));
    }
}
