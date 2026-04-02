//Time & Space Complexity 
//Time: O(V + E) (DFS visits every vertex and edge once).
//Space: O(V) (for visited[], stack[], and recursion depth).

import java.util.ArrayList;

public class CycleDetectionInDirectedGraph {
    public static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;

        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));

    }

    public static boolean IsCycle(ArrayList<Edge>[] graph) {

        boolean visit[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]) {
                if (IsCycleutil(graph, i, visit, stack)) {
                    return true;
                }
            }

        }
        return false;
    }

    public static boolean IsCycleutil(ArrayList<Edge>[] graph, int i, boolean[] visit, boolean[] stack) {
        visit[i] = true;
        stack[i] = true;
        for (int j = 0; j < graph[i].size(); j++) {
            Edge e = graph[i].get(j);
            if (stack[e.dest] == true) {
                return true;
            } else if (!visit[e.dest] && IsCycleutil(graph, e.dest, visit, stack)) {
                return true;
            }
        }
        stack[i] = false;
        return false;
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        System.out.println(IsCycle(graph));

    }
}
