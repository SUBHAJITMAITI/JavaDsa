//Time Complexity : O(n*target)
//Space Complexity:  O(n*target)

public class TargetSumSubset {
    public static boolean targetSumSubset(int[] numbers, int target) {
        int n = numbers.length;
        boolean[][] dp = new boolean[n + 1][target + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                int v = numbers[i - 1];
                // include
                if (v <= j && dp[i - 1][j - v] == true) {

                    dp[i][j] = true;

                }
                // exclude
                else if (dp[i - 1][j] == true) {
                    dp[i][j] = true;
                }

            }
        }
        print(dp);
        return dp[n][target];
    }

    public static void print(boolean dp[][]) {
        for (int i = 0; i < dp.length; i++) {

            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] numbers = { 4, 2, 7, 1, 3 };
        int target = 10;
        System.out.println(targetSumSubset(numbers, target));

    }
}
