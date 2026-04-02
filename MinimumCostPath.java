// Time Complexity : O(N * M * log(N * M))
// Space Complexity: O(N * M)

import java.util.*;

public class MinimumCostPath {
    public static int minCost(int grid[][]) {
        // Directions: up, down, left, right
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        int n = grid.length;
        int m = grid[0].length;

        // dist[i][j] stores the minimum cost to reach cell (i, j)
        int[][] dist = new int[n][m];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE); // initialize with "infinity"
        }
        dist[0][0] = grid[0][0]; // starting point

        // PriorityQueue -> min-heap, stores {cost, x, y}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] { grid[0][0], 0, 0 }); // {cost, row, col}

        int cost = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currCost = curr[0];
            int x = curr[1];
            int y = curr[2];

            // If we reached bottom-right cell → answer found
            if (x == n - 1 && y == m - 1) {
                cost = currCost;
                break;
            }

            // Explore all 4 directions
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                // Check boundaries
                if (newX >= 0 && newY >= 0 && newX < n && newY < m) {
                    int newCost = currCost + grid[newX][newY];

                    // Relaxation: if new cost is better, update and push in PQ
                    if (newCost < dist[newX][newY]) {
                        dist[newX][newY] = newCost;
                        pq.add(new int[] { newCost, newX, newY });
                    }
                }
            }
        }

        // (Optional) print dist matrix for debugging
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         System.out.print(dist[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        return cost;
    }

    public static void main(String[] args) {
        int[][] grid = {
            { 31, 100, 65, 12, 18 },
            { 10,  13, 47, 157,  6 },
            {100, 113, 174,  11, 33 },
            { 88, 124,  41,  20, 140 },
            { 99,  32, 111,  41,  20 }
        };

        System.out.println("Minimum cost = " + minCost(grid));
    }
}
