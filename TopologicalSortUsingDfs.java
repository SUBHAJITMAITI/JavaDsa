//Time Complexity: O(V + E)
//Space Complexity: O(V)

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortUsingDfs {
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

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

    }

    public static void topSort(ArrayList<Edge>[] graph) {
        boolean[] visit = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]) {
                topSortUtil(graph, i, visit, s); // modified dfs
            }
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }

    }

    public static void topSortUtil(ArrayList<Edge>[] graph, int i, boolean[] visit, Stack<Integer> s) {
        visit[i] = true;
        for (int j = 0; j < graph[i].size(); j++) {
            Edge e = graph[i].get(j);
            if (!visit[e.dest]) {
                topSortUtil(graph, e.dest, visit, s);
            }
        }
        s.add(i);
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        topSort(graph);
    }
}
