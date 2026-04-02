//Time Complexity: O(n × m)
//Space Complexity: O(n × m)

public class Find_number_of_closed_islands {
    public static void dfs(int mat[][], int i, int j, boolean[][] visited) {
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || visited[i][j] || mat[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        dfs(mat, i + 1, j, visited);
        dfs(mat, i - 1, j, visited);
        dfs(mat, i, j + 1, visited);
        dfs(mat, i, j - 1, visited);

    }

    public static int FindClosedIslands(int mat[][], int n, int m) {
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    if(mat[i][j]==1){
                    dfs(mat, i, j, visited);
                    }
                }
            }
        }

        int island = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1 && !visited[i][j]) {
                    dfs(mat, i, j, visited);
                    island++;

                }
            }
        }
        return island;
    }

    public static void main(String[] args) {
        int n = 5, m = 8;
        int mat[][] = { { 0, 0, 0, 0, 0, 0, 0, 1 },
                { 0, 1, 1, 1, 1, 0, 0, 1 },
                { 0, 1, 0, 1, 0, 0, 0, 1 },
                { 0, 1, 1, 1, 1, 0, 1, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1 } };
        System.out.println("Number of closed islands : " + FindClosedIslands(mat, n, m));
    }
}
