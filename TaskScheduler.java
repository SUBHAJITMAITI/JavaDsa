import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
public class TaskScheduler {
    public static boolean canFinish(int numTasks, int[][] prerequisites) {
        // Step 1: Create adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numTasks; i++) {
            graph.add(new ArrayList<>());
        }

        // Step 2: Calculate indegree of each node
        int[] indegree = new int[numTasks];
        for (int[] pre : prerequisites) {
            int dest = pre[0];
            int src = pre[1];
            graph.get(src).add(dest);
            indegree[dest]++;
        }

        // Step 3: Add all 0-indegree nodes to queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numTasks; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Step 4: BFS processing
        int count = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;

            for (int neighbor : graph.get(curr)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        // Step 5: If all nodes processed -> no cycle
        return count == numTasks;
    }

    public static void main(String[] args) {
        int numTasks = 4;

        // Example 1: Cycle exists
        int[][] prerequisites1 = { {1, 0}, {0, 1} };
        System.out.println("Example 1: " + canFinish(numTasks, prerequisites1)); // false

        // Example 2: No cycle
        int[][] prerequisites2 = { {1, 0}, {2, 0}, {3, 1}, {3, 2} };
        System.out.println("Example 2: " + canFinish(numTasks, prerequisites2)); // true
    }
}
