public class Number_of_Parenthesis_Combinations {
    public static int count = 0;

    // Recursive generation
    // Time Complexity : O(Cₙ × n)
    // Space Complexity: O(n)
    public static void combinations(int n, int open, int colse, String s) {
        if (s.length() == 2 * n) {
            count++;
            System.out.println(s);
        }
        if (open < n) {
            combinations(n, open + 1, colse, s + "(");
        }
        if (colse < open) {
            combinations(n, open, colse + 1, s + ")");
        }

    }

    // Tabulation
    // Time Complexity : O(n²)
    // Space Complexity: O(n)

    public static int countParenthesis(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1; // empty
        dp[1] = 1; // ()

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }

        }
        return dp[n];

    }

    // memoization
    // Time Complexity : O(n²)
    // Space Complexity: O(n)
    public static int countParenthesis1(int n, int dp[]) {
        if (n < 2) {
            return 1;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += countParenthesis1(i, dp) * countParenthesis1(n - 1 - i, dp);
        }
        dp[n] = ans;
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 3;
        combinations(n, 0, 0, "");
        System.out.println(count);

        System.out.println(countParenthesis(n));
        int dp[] = new int[n + 1];
        System.out.println(countParenthesis1(n, dp));
    }
}
