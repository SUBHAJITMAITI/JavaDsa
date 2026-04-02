//Tabulation 

//time complexity: O (n*m)
//space complexity: O (n*m)
public class wildcardMatching {
    public static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean dp[][] = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = false;
        }
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // bottom up

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];

    }

    // space optimaization

    // time complexity: O (n*m)
    // space complexity: O (m)
    public static boolean isMatch1(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean prev[] = new boolean[m + 1];
        boolean curr[] = new boolean[m + 1];
        prev[0] = true;
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                prev[j] = prev[j - 1];
            }
        }
        for (int i = 1; i <= n; i++) {
            curr[0] = false;
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    curr[j] = prev[j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    curr[j] = prev[j] || curr[j - 1];
                } else {
                    curr[j] = false;
                }
            }
            boolean temp[] = curr.clone();
            prev = temp;
            curr = new boolean[m + 1];

        }

        return prev[m];

    }

    public static void main(String[] args) {
        String s = "baaaab";
        String p = "*****ba*****ab";
        // String s = "aa";
        // String p = "b";
        System.out.println(isMatch(s, p));
        System.out.println(isMatch1(s, p));
    }
}
