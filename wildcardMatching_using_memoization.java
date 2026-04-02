//Time Complexity	O(n * m)
//Space Complexity	O(n * m)
public class wildcardMatching_using_memoization {
    public static boolean isMatch(String s, String p, Boolean dp[][], int n, int m) {
        if (n == 0 && m == 0) {
            dp[n][m] = true;
            return dp[n][m];
        }
        if (dp[n][m] != null) {
            return dp[n][m];
        }
         if (n == 0) {
            dp[n][m] =p.charAt(m - 1) == '*' && isMatch(s, p, dp, n, m - 1);
            return dp[n][m];
        }
        if (m == 0) {
            dp[n][m] = false;
            return dp[n][m]; 
        }
       

        if (s.charAt(n - 1) == p.charAt(m - 1) || p.charAt(m - 1) == '?') {
            dp[n][m] = isMatch(s, p, dp, n - 1, m - 1);
            return dp[n][m];
        } else if (p.charAt(m - 1) == '*') {
            dp[n][m] = isMatch(s, p, dp, n, m - 1) || isMatch(s, p, dp, n - 1, m);
            return dp[n][m];
        } else {
            dp[n][m] = false;
            return dp[n][m];
        }

    }

    public static void main(String[] args) {
        String s = "baaaab";
        String p = "*****ba*****ab";
        int n = s.length();
        int m = p.length();
        Boolean dp[][] = new Boolean[n + 1][m + 1];
        System.out.println(isMatch(s, p, dp, n, m));
    }
}
