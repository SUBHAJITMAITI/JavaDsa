//Time (DFS twice)	= O(V + E)
//Space (visited + recursion) =	O(V)

import java.util.ArrayList;
import java.util.Arrays;

// Perform DFS starting from vertex i
public class MotherVertex {
    public static void dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[i] = true;
        for (int j = 0; j < adj.get(i).size(); j++) {
            if (!visited[adj.get(i).get(j)]) {
                dfs(adj.get(i).get(j), adj, visited);
            }

        }

    }

      // Function to find a mother vertex

    public static int findMotherVertex(int v, ArrayList<ArrayList<Integer>> adj) {

        boolean visited[] = new boolean[v];
        int lastVertex = 0;

         // Step 1: Perform DFS for all vertices
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited);
                lastVertex = i; // candidate for mother vertex
            }
        }
        // Step 2: Check if candidate is actually a mother vertex
        Arrays.fill(visited, false);
        dfs(lastVertex, adj, visited);
        for (boolean b : visited) {
            if (!b) {
                return -1; // No mother vertex exists
            }

        }

        return lastVertex;

    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(2);

        adj.get(1).add(4);
        adj.get(1).add(3);

        adj.get(2).add(3);

        adj.get(3).add(5);

        adj.get(5).add(4);


        int motherVertex = findMotherVertex(v, adj);
        if (motherVertex != -1) {
            System.out.println("Mother Vertex is: " + motherVertex);
        } else {
            System.out.println("No Mother Vertex exists");
        }
    }
}
