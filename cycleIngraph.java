//Time Complexity: O(V + E)
//Space Complexity: O(V + E)

import java.util.ArrayList;

public class cycleIngraph {
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

    public static boolean dfs(ArrayList<Edge>[] graph) {
        boolean visit[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]) {
                if (dfsutil(graph, visit, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfsutil(ArrayList<Edge>[] graph, boolean[] visit, int curr, int par) {

        visit[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            // case -3
            if (!visit[e.dest]) {
                if (dfsutil(graph, visit, e.dest, curr)) {
                    return true;
                }
            }

            // case -1
            else if (visit[e.dest] && e.dest != par) {
                return true;
            }

            // case -2 -> do nothing -> continue
        }
        return false;
    }

    public static void main(String[] args) {
        /*
         *   1---3
         * /     |  \
         * 0     |   5--6
         * \     |  /
         *   2---4
         * 
         */

        int v = 7;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        System.out.println(dfs(graph));

    }
}
