public class Tribonacci_Numbers {

    // Time Complexity:O(N)
    // Space Complexity:O(N)
    public static int Tribonacci(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = Tribonacci(n - 1, dp) + Tribonacci(n - 2, dp) + Tribonacci(n - 3, dp);
        return dp[n];
    }

    // Time Complexity:O(N)
    // Space Complexity:O(1)
    public static int Tribonacci1(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        int a = 0, b = 0, c = 1;
        int d = 0;
        for (int i = 3; i <= n; i++) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;

        }
        return d;
    }

    public static void main(String[] args) {
        int n = 5;
        int dp[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            System.out.print(Tribonacci(i, dp) + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(Tribonacci1(i) + " ");
        }
    }
}
