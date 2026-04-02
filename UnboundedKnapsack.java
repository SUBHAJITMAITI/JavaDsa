//Time Complexity: O(n×weight)
//Space complexity:O(n×weight)

public class UnboundedKnapsack {
    public static int find_max(int[] val, int[] wt, int weight) {
        int n = val.length;
        int[][] dp = new int[n + 1][weight + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < weight + 1; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < weight + 1; j++) {
                int v = val[i - 1];
                int w = wt[i - 1];
                if (w <= j) { // valid
                    // int raw = w;
                    // int real = v;
                    // while (w <= j) {
                    // w += raw;
                    // v += real;
                    // }
                    // w = w - raw;
                    // v = v - real;
                    // int incProfit = v + dp[i - 1][j - w];
                    // int excProfit = dp[i - 1][j];
                    dp[i][j] = Math.max(v + dp[i][j - w], dp[i - 1][j]);
                } else { // invalid
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        print(dp);
        return dp[n][weight];
    }

    public static void print(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {

            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // int[] val = { 15, 14, 10, 45, 30 };
        // int[] wt = { 2, 5, 1, 3, 4 };
        // int weight = 7;
        // System.out.println(find_max(val, wt, weight));
        int[] val = { 10, 30, 20 };
        int[] wt = { 5, 10, 15 };
        int weight = 20;
        System.out.println(find_max(val, wt, weight));

        // find_max(val, wt, weight);
    }
}
