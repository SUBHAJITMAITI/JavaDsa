//Time Complexity: O(V*E)
//Space Complexity: O(V + E)
import java.util.ArrayList;

public class BellmanFord {
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

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));

    }

    public static void bellmanFord(ArrayList<Edge>[] graph, int src) {

        int dist[] = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        int V = graph.length;

        // O(V*E)

        // algo -O(V)
        for (int i = 0; i < V - 1; i++) {
            // edge -O(E)
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    // u,v,wt
                    int u = graph[j].get(k).src;
                    int v = graph[j].get(k).dest;
                    int weight = graph[j].get(k).weight;
                    // relaxation
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                    }

                }
            }

        }
        // print
        for (int i = 0; i < dist.length; i++) {

            System.out.print(dist[i] + " ");
        }
        System.out.println();

    }

    public static void createGraph(ArrayList<Edge> a) {
        // only store edges information
        a.add(new Edge(0, 1, 2));
        a.add(new Edge(0, 2, 4));

        a.add(new Edge(1, 2, -4));

        a.add(new Edge(2, 3, 2));

        a.add(new Edge(3, 4, 4));

        a.add(new Edge(4, 1, -1));

    }

    public static void bellmanFord(ArrayList<Edge> a, int src, int V) {

        int dist[] = new int[V];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        // O(V*E)

        // algo -O(V)
        for (int i = 0; i < V - 1; i++) {
            // edge -O(E)

            for (int k = 0; k < a.size(); k++) {
                // u,v,wt
                int u = a.get(k).src;
                int v = a.get(k).dest;
                int weight = a.get(k).weight;
                // relaxation
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }

            }

        }
        // print
        for (int i = 0; i < dist.length; i++) {

            System.out.print(dist[i] + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int v = 5;
        // ArrayList<Edge>[] graph = new ArrayList[v];
        // createGraph(graph);
        // bellmanFord(graph, 0);

        ArrayList<Edge> a = new ArrayList<>();
        createGraph(a);
        bellmanFord(a, 0, v);
    }
}
