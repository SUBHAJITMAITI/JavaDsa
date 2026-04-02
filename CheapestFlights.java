//Time Complexity = O(k × E)
//Space Complexity = O(n + E)
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlights {
    static class Edge {

        int src;
        int dest;
        int weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

    }

    public static void createGraph(int[][] flights, ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int weight = flights[i][2];
            graph[src].add(new Edge(src, dest, weight));

        }
    }

    public static class info {
        int src;
        int cost;
        int stops;

        info(int s, int d, int k) {
            this.src = s;
            this.cost = d;
            this.stops = k;
        }

    }

    public static int FindCheapestFlights(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(flights, graph);
        int dist[] = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        Queue<info> q = new LinkedList<>();
        q.add(new info(src, 0, 0));
        while (!q.isEmpty()) {
            info curr = q.remove();
            if (curr.stops > k) {
                break;
            }

            for (int i = 0; i < graph[curr.src].size(); i++) {
                Edge e = graph[curr.src].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.weight;
                if (curr.cost + wt < dist[v] && curr.stops <= k) {
                    dist[v] = curr.cost + wt;
                    q.add(new info(v, dist[v], curr.stops + 1));
                }
            }

        }
        if (dist[dst] != Integer.MAX_VALUE) {
            return dist[dst];
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int src = 0, dst = 3, k = 1;
        System.out.println(FindCheapestFlights(n, flights, src, dst, k));
    }
}
