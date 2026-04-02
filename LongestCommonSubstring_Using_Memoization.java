//Time Complexity=O(n×m)
//Space Complexity=O(n×m)

public class LongestCommonSubstring_Using_Memoization {
    static int result = 0; // global variable to store max length
    static int EndingIndex = 0;

    public static int Find(String str1, String str2, int dp[][], int n, int m, int length) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        // recursive cases
        int val = 0;
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            val = Find(str1, str2, dp, n - 1, m - 1, length + 1) + 1;
            // result = Math.max(result, val);
            if (val > result) {
                result = val;
                EndingIndex = n - 1; // track ending index of substring
            }
        }
        // explore other possibilities (reset count)
        Find(str1, str2, dp, n - 1, m, 0);
        Find(str1, str2, dp, n, m - 1, 0);
        dp[n][m] = val;
        return dp[n][m];

    }

    public static void main(String[] args) {
        String str1 = "ABCDE";
        String str2 = "ABGCE";
        // String str1 = "AMC";
        // String str2 = "ANC";
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = -1;
                }
            }

        }
        int length = 0;
        Find(str1, str2, dp, n, m, length);
        System.out.println(result);
        System.out.println("Longest Substring : "+ str1.substring(EndingIndex-result+1, EndingIndex+1));

    }

}
