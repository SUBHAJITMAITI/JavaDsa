//Time Complexity:  O(n*w)
//Space Complexity: O(n*w)
public class MinimumPartitioning {

    public static int partitioning(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        int w = sum / 2;
        System.out.println(w);
        int dp[][] = new int[n + 1][w + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (arr[i - 1] <= j) { // valid
                    dp[i][j] = Math.max(arr[i - 1] + dp[i - 1][j - arr[i - 1]], dp[i - 1][j]);
                } else { // invalid
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        int sum1 = dp[n][w];
        int sum2 = sum - sum1;

        return Math.abs(sum1 - sum2);

    }

    // space optimized
    // Time Complexity: O(n*w)
    // Space Complexity: O(w)
    public static int partitioning1(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        int w = sum / 2;
        int prev[] = new int[w + 1];
        int curr[] = new int[w + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (arr[i - 1] <= j) { // valid
                    curr[j] = Math.max(arr[i - 1] + prev[j - arr[i - 1]], prev[j]);
                } else { // invalid
                    curr[j] = prev[j];
                }
            }
            prev = curr.clone();
        }
        int sum1 = prev[w];
        int sum2 = sum - sum1;

        return Math.abs(sum1 - sum2);

    }

    public static void main(String[] args) {
        int arr[] = { 1, 6, 11, 5 };
        System.out.println(partitioning(arr));
        System.out.println(partitioning1(arr));
    }
}
