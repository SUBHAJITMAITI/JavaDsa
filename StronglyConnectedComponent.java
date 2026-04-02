//Time Complexity = O(V + E)
//Space Complexity = O(V + E)

import java.util.ArrayList;
import java.util.Stack;

public class StronglyConnectedComponent {

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
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }

    public static void topSort(ArrayList<Edge>[] graph, int i, Stack<Integer> s, boolean[] visited) {
        visited[i] = true;
        for (int j = 0; j < graph[i].size(); j++) {
            Edge e = graph[i].get(j);
            if (!visited[e.dest]) {
                topSort(graph, e.dest, s, visited);
            }
        }
        s.push(i);
    }

    public static void dfs(ArrayList<Edge>[] graph, int i, boolean[] visited) {
        visited[i] = true;
        System.out.print(i + " ");
        for (int j = 0; j < graph[i].size(); j++) {
            Edge e = graph[i].get(j);
            if (!visited[e.dest]) {
                dfs(graph, e.dest, visited);
            }
        }

    }

    public static void Kosaraju(ArrayList<Edge>[] graph, int v) { // O(V+E)
        // Step1
        boolean[] visited = new boolean[v];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                topSort(graph, i, s, visited);
            }

        }

        // step 2
        ArrayList<Edge>[] transpose = new ArrayList[v];
        for (int i = 0; i < transpose.length; i++) {
            transpose[i] = new ArrayList<>();
        }
        for (int i = 0; i < graph.length; i++) {
            visited[i] = false;
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);// e.src -> e.dest
                int src = e.src;
                int dest = e.dest;
                transpose[dest].add(new Edge(dest, src)); // reverse edge
            }
        }

        // step 3
        while (!s.isEmpty()) {
            int i = s.pop();
            if (!visited[i]) {
                System.out.print("SCC -> ");
                dfs(transpose, i, visited);
                System.out.println();
            }

        }

    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];

        createGraph(graph);
        Kosaraju(graph, v);
    }
}
