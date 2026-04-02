//Time Complexity: O(N × M)
//Space Complexity: O(N × M)

public class LongestPath {
    public static int findpath(int m[][], int N, int M, int i, int j, int dp[][]) {
        if (i == N - 1 && j == M - 1) {

            return 1;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int len1 = 0;
        if (i < N - 1 && m[i + 1][j] > m[i][j]) {
            len1 = findpath(m, N, M, i + 1, j, dp);
        }
        int len2 = 0;
        if (j < M - 1 && m[i][j + 1] > m[i][j]) {
            len2 = findpath(m, N, M, i, j + 1, dp);
        }
        dp[i][j] = 1 + Math.max(len1, len2);
        return dp[i][j];

    }

    public static void main(String[] args) {

        int m[][] = { { 1, 2, 3, 4 },
        { 2, 2, 3, 4 },
        { 3, 2, 3, 4 },
        { 4, 5, 6, 7 } };
        // int m[][] = { { 1, 2 },
        //         { 3, 4 } };
        int dp[][] = new int[m.length][m[0].length];
        System.out.println(findpath(m, m.length, m[0].length, 0, 0, dp));

    }
}
