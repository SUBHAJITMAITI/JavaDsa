//Time Complexity :	O(E log E) ≈ O(E log V)
//Space Complexity : O(V + E)

import java.util.ArrayList;
import java.util.Collections;

public class KrushkalAlgorithm {
    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int weight;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.weight = w;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.weight - e2.weight;
        }
    }

    public static void createGraph(ArrayList<Edge> edges) {
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));

    }

    static int n = 4;
    static int[] par = new int[n];
    static int[] rank = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }

    }

    public static int find(int x) { // Time Complexity (per operation) O(α(N)) ≈ O(1)
        if (x == par[x]) {
            return x;
        }

        return par[x] = find(par[x]); //path compression

    }

    public static void union(int a, int b) { // Time Complexity (per operation) O(α(N)) ≈ O(1)
        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }

    }

    public static void KrushkalsMST(ArrayList<Edge> edges, int v) {
        init();
        Collections.sort(edges); // O(ElogE)
        int FinalCost = 0;
        int count = 0;
        for (int i = 0; count < v - 1; i++) { // O(V)
            Edge e = edges.get(i);
            // (src,dest,weight)
            int parA = find(e.src); // src=a
            int parB = find(e.dest); // src=b
            if (parA != parB) {
                union(e.src, e.dest);
                FinalCost += e.weight;
                count++;

            }

        }
        System.out.println(FinalCost);

    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        KrushkalsMST(edges, v);
    }
}
