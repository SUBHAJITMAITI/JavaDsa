//Time Complexity: O(V)+O(E⋅α(V))≈O(V+E)
//Space Complexity:O(V+E)

import java.util.ArrayList;

public class Union_Find {
    public static class Edge {
        int src;
        int dest;

        Edge(int u, int v) {
            this.src = u;
            this.dest = v;
        }
    }

    public static int[] par;
    public static int rank[];

    public static void init(int v) {
        par = new int[v];
        rank = new int[v];
        for (int i = 0; i < v; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {

        if (x == par[x]) {
            return x;
        }
        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {
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

    public static boolean findCycle(int v, ArrayList<Edge> a) {
        init(v);
        for (int i = 0; i < a.size(); i++) {
            Edge e = a.get(i);
            int A = find(e.src);
            int B = find(e.dest);

            if (A == B) {
                return true;
            }
            union(A, B);

        }
        return false;
    }

    public static void main(String[] args) {
        int v = 10;
        ArrayList<Edge> a = new ArrayList<>();
        a.add(new Edge(1, 9));
        a.add(new Edge(1, 5));
        a.add(new Edge(9, 5));
        a.add(new Edge(5, 2));
        a.add(new Edge(2, 7));
        System.out.println(findCycle(v, a));

    }
}
