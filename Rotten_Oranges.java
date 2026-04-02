//Time Complexity : o(N*M)
//Space Complexity: o(N*M)

import java.util.LinkedList;
import java.util.Queue;

public class Rotten_Oranges {
    static class info {
        int i;
        int j;
        int time;

        info(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }

    public static int orangeRotting(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int max = 0; // for time tracking
        boolean[][] visit = new boolean[n][m];

        Queue<info> q = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 2) {
                    q.add(new info(i, j, 0));
                    visit[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            info s = q.remove();
            int i = s.i;
            int j = s.j;
            int time = s.time;
            max = Math.max(max, time);
            if (i - 1 >= 0 && !visit[i - 1][j] && arr[i - 1][j] == 1) {
                q.add(new info(i - 1, j, time + 1));
                visit[i - 1][j] = true;
            }
            if (j - 1 >= 0 && !visit[i][j - 1] && arr[i][j - 1] == 1) {
                q.add(new info(i, j - 1, time + 1));
                visit[i][j - 1] = true;
            }
            if (i + 1 < n && !visit[i + 1][j] && arr[i + 1][j] == 1) {
                q.add(new info(i + 1, j, time + 1));
                visit[i + 1][j] = true;
            }
            if (j + 1 < m && !visit[i][j + 1] && arr[i][j + 1] == 1) {
                q.add(new info(i, j + 1, time + 1));
                visit[i][j + 1] = true;
            }

        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1 && !visit[i][j]) {
                    return -1;
                }
            }
        }

        return max;

    }

    public static void main(String[] args) {
        int arr[][] = { { 2, 1, 0, 2, 1 },
                        { 0, 0, 1, 2, 1 },
                        { 1, 0, 0, 2, 1 } };

        System.out.println(orangeRotting(arr));
    }
}
