//Time Complexity: O(V + E)
//Space Complexity: O(V + E)

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class ConnectedComponent {
    public static class Edge {
        int src;
        int dest;
        int weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }

    public static void bfs(ArrayList<Edge>[] graph) {
        boolean visit[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]) {
                bfsutil(graph,i, visit);
            }
        }
    }

    public static void bfsutil(ArrayList<Edge>[] graph,int src, boolean[] visit) { // O(V+E)
        Queue<Integer> q = new LinkedList<>();

        q.add(src); // source=0
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!visit[curr]) { // visit curr
                System.out.print(curr + " ");
                visit[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

      public static void dfs(ArrayList<Edge>[] graph) {
        boolean visit[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]) {
                dfsutil(graph, i,visit);
            }
        }
    }
    public static void dfsutil(ArrayList<Edge>[] graph, int v, boolean[] visit) {

        System.out.print(v + " ");
        visit[v] = true;
        for (int i = 0; i < graph[v].size(); i++) {
            int curr = graph[v].get(i).dest;
            if (!visit[curr]) {
                dfsutil(graph, curr, visit);
            }
        }

    }

    public static void main(String[] args) {
        /*
         *    1---3
         *   /    | \
         * 0      |  5--6
         *  \     | /
         *    2---4
         * 
         */

        int v = 7;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        bfs(graph);
        System.out.println();
        dfs(graph);
    }
}
