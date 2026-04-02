import java.util.Arrays;

public class StringConversion {
    public static int Tabulation(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int prev[] = new int[m + 1];
        int curr[] = new int[m + 1];
        // bottom up
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + 1;
                } else {
                    int ans1 = prev[j];
                    int ans2 = curr[j - 1];
                    curr[j] = Math.max(ans1, ans2);
                }
            }
            prev = curr.clone();
        }
        return curr[m];
    }

    public static int Find(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int prev[] = new int[m + 1];
        int curr[] = new int[m + 1];
        for (int i = 0; i < m + 1; i++) {
            prev[i] = i;
        }
        // bottom up
        for (int i = 1; i < n + 1; i++) {
            curr[0] = i;
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    int add = prev[j];
                    int del = curr[j - 1];
                    curr[j] = Math.min(add, del) + 1;
                }
            }
            prev = curr.clone();
        }
        return curr[m];
    }

    public static int memoization(String str1, String str2, int n, int m, int dp[][]) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) { // same
            dp[n][m] = memoization(str1, str2, n - 1, m - 1, dp) + 1;
            return dp[n][m];
        } else { // diff
            int ans1 = memoization(str1, str2, n - 1, m, dp);
            int ans2 = memoization(str1, str2, n, m - 1, dp);
            dp[n][m] = Math.max(ans1, ans2);
            return dp[n][m];
        }
    }

    public static int memoization1(String str1, String str2, int n, int m, int dp[][]) {
        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) { // same
            dp[n][m] = memoization1(str1, str2, n - 1, m - 1, dp);
            return dp[n][m];
        } else { // diff
            int add = memoization1(str1, str2, n - 1, m, dp);
            int del = memoization1(str1, str2, n, m - 1, dp);
            dp[n][m] = Math.min(add, del) + 1;
            return dp[n][m];
        }
    }

    public static void main(String[] args) {
        String str1 = "pear";
        String str2 = "sea";
        // Tabulation
        int val = Tabulation(str1, str2);
        int n = str1.length();
        int m = str2.length();

        System.out.println("to convert from str1 to str2 require operation : " + (n - val + m - val));
        // Another approach
        System.out.println(Find(str1, str2));

        // memoization
        int dp[][] = new int[n + 1][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int val1 = memoization(str1, str2, n, m, dp);
        System.out.println("to convert from str1 to str2 require operation : " + (n - val1 + m - val1));

        // Another approach
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(memoization1(str1, str2, n, m, dp));

    }
}
