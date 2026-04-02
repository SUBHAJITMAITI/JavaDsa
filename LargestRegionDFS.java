//Time Complexity : o(N*M)
//Space Complexity: o(N*M)

public class LargestRegionDFS {
    static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

    public static int find(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        boolean[][] visit = new boolean[n][m];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && !visit[i][j]) {
                    int area = dfs(arr, i, j, visit);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    public static int dfs(int[][] arr, int i, int j, boolean[][] visit) {
        int n = arr.length, m = arr[0].length;

        visit[i][j] = true;
        int count = 1;

        // Explore 8 directions
        for (int l = 0; l < 8; l++) {
            int ndx = i + dx[l];
            int ndy = j + dy[l];
            if (ndx >= 0 && ndx < n && ndy >= 0 && ndy < m && !visit[ndx][ndy] && arr[ndx][ndy] == 1) {
                count += dfs(arr, ndx, ndy, visit);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] arr = {
                { 0, 0, 1, 1, 0 },
                { 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1 }
        };

        System.out.println(find(arr)); // Output: 5
    }
}
