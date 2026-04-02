//Time Complexity : o(N*M)
//Space Complexity: o(N*M)

import java.util.LinkedList;
import java.util.Queue;

public class Find_the_size_of_the_largest_region_in_the_Boolean_Matrix {
    static class info {
        int i;
        int j;


        info(int i, int j) {
            this.i = i;
            this.j = j;
          
        }

    }

    public static int find(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int area = 0;
        boolean[][] visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] ==1 &&  !visit[i][j]) {
                    area = Math.max(area, findArea(arr, i, j, visit));
                }
            }
        }

        return area;
    }

    static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

    public static int findArea(int[][] arr, int i, int j, boolean[][] visit) {
        int n = arr.length;
        int m = arr[0].length;
        Queue<info> q = new LinkedList<>();
        visit[i][j] = true;
        int maxArea = 1;
        q.add(new info(i, j));
        while (!q.isEmpty()) {
            info f = q.remove();
           
            for (int l = 0; l < 8; l++) {
                int ndx = f.i + dx[l];
                int ndy = f.j + dy[l];
                if (ndx >= 0 && ndx < n && ndy >= 0 && ndy < m && !visit[ndx][ndy] && arr[ndx][ndy] == 1) {
                    maxArea++;
                    q.add(new info(ndx, ndy));
                    visit[ndx][ndy] = true;
                }
            }

        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[][] arr = { { 0, 0, 1, 1, 0 }, { 0, 0, 1, 1, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 1 } };
        System.out.println(find(arr));

    }
}
