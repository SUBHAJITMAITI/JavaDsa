public class LongestCommonSubstring_Using_Tabulation {
    // Time Complexity=O(n×m)
    // Space Complexity=O(n×m)
    public static int Find(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }

        }
        int EndingIndex = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    // ans = Math.max(ans, dp[i][j]);
                    if (ans < dp[i][j]) {
                        ans = dp[i][j];
                        EndingIndex = i - 1;
                    }

                } else {

                    dp[i][j] = 0;

                }
            }
        }

        // print
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("SubString : " + str1.substring(EndingIndex - ans + 1, EndingIndex + 1));
        return ans;
    }

    // Time Complexity=O(n×m)
    // Space optimized : O(n)
    public static int Find1(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];
        prev[0] = 0;
        int ans = 0;
        int EndingIndex = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + 1;
                    if (ans < curr[j]) {
                        ans = curr[j];
                        EndingIndex = i - 1;
                    }
                } else {
                    curr[j] = 0;
                }
            }
            prev = curr.clone();

        }

        System.out.println();
        System.out.println("SubString : " + str1.substring(EndingIndex - ans + 1, EndingIndex + 1));
        return ans;
    }

    public static void main(String[] args) {

        String str1 = "ABCDE";
        String str2 = "ABGCE";

        System.out.println(Find(str1, str2));
        System.out.println(Find1(str1, str2));
    }
}
