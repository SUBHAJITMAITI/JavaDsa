//P = number of paths from src → dest
//V = max path length (≤ number of vertices)
//Time Complexity: O(P × V) (exponential in number of paths) 


//Recursion stack: depth ≤ V → O(V)
//Path string (s+src): each concat = O(V) per call → total O(P × V)
//Graph storage: adjacency list = O(V + E)
//Space Complexity: O(V + E + P × V)

import java.util.ArrayList;


public class AllPathsFromSourceToDestination {
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

        graph[0].add(new Edge(0, 3));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

    }

    public static void Find_path(ArrayList<Edge>[] graph, int src, int dest, String s) {

        if (src == dest) {
            System.out.println(s + dest);

            return;
        }
        for (int i = 0; i < graph[src].size(); i++) {

            Find_path(graph, graph[src].get(i).dest, dest, s + src);
        }

    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
      

        Find_path(graph, 5, 1, "");
    }
}
