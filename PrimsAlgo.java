//Time Complexity: O(E log V)
//Space complexity: O(V + E)

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {
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

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));

    }

    static class pair implements Comparable<pair> {
        int node;
        int cost;
        int parent;

        pair(int node, int cost, int parent) {
            this.node = node;
            this.cost = cost;
            this.parent = parent;
        }

        @Override
        public int compareTo(pair p2) {

            return this.cost - p2.cost; // ascending
        }

    }

    public static void findMST(ArrayList<Edge>[] graph, int src) {
        boolean visit[] = new boolean[graph.length];
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(src, 0, -1));
        int FinalCost = 0;
        ArrayList<Edge> mstEdges = new ArrayList<>();
        while (!pq.isEmpty()) {
            pair curr = pq.remove();
            if (!visit[curr.node]) {
                // store the edge in MST (except the starting node)
                if (curr.parent != -1) {
                    mstEdges.add(new Edge(curr.parent, curr.node, curr.cost));
                }
                FinalCost += curr.cost;
                visit[curr.node] = true;
                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    if (!visit[e.dest]) {
                        pq.add(new pair(e.dest, e.weight, curr.node));
                    }
                }

            }
        }
        System.out.println("Edges in Minimum Spanning Tree:");
        for (Edge e : mstEdges) {
            System.out.println(e.src + " - " + e.dest + " (" + e.weight + ")");
        }
        System.out.println("Final (Minimum) Cost of MST = " + FinalCost);
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        findMST(graph, 0);
    }
}
