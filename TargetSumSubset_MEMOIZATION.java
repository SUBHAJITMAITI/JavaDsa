//Time Complexity: O(n×target)
//Space complexity:O(n×target)
public class TargetSumSubset_MEMOIZATION {

    public static boolean targetSumSubset(int[] numbers, int n, int target, Boolean[][] dp) {
        if (target == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        if (dp[n][target] != null) {
            return dp[n][target];
        }

        if (numbers[n - 1] <= target) {
            boolean incVal = targetSumSubset(numbers, n - 1, target - numbers[n - 1], dp);
            boolean excVal = targetSumSubset(numbers, n - 1, target, dp);
          dp[n][target]=incVal || excVal;
            return dp[n][target];
        } else {
            dp[n][target]= targetSumSubset(numbers, n - 1, target, dp);
            return dp[n][target];
        }
    }

    public static void main(String[] args) {
        int[] numbers = { 4, 2, 7, 1, 3 };
        int target = 2;
        int n = numbers.length;
        // boolean[][] dp = new boolean[n + 1][target + 1]; //default value :false
        Boolean[][] dp = new Boolean[n + 1][target + 1]; // default value :null
        System.out.println(targetSumSubset(numbers, numbers.length, target, dp));

    }
}
