import java.util.Arrays;

public class Catalan_Number {
    // Time Complexity → O(2^n) (Exponential)
    // Space Complexity → O(n) (Stack depth)
    public static int catalanRec(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += catalanRec(i) * catalanRec(n - i - 1);
        }
        return ans;
    }

    // memoization
    // Time Complexity → O(n^2) (Polynomial)
    // Space Complexity → O(n)
    public static int catalanMem(int n, int dp[]) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += catalanMem(i, dp) * catalanMem(n - i - 1, dp);

        }
        return dp[n] = ans;
    }

    // Tabulation
    // Time Complexity → O(n^2)
    // Space Complexity → O(n)
    public static int catTab(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int ans = 0;
            for (int j = 0; j < i; j++) {
                ans += dp[j] * dp[i - j - 1];
            }
            dp[i] = ans;
        }
        return dp[n];

    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(catalanRec(n));
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(catalanMem(n, dp));
        System.out.println(catTab(n));
    }
}
