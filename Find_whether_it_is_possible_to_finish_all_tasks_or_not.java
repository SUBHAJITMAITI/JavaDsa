//Time Complexity : O(V + E * α(V)) ≈ O(V + E)
// Space Complexity : O(V + E)

import java.util.ArrayList;

public class Find_whether_it_is_possible_to_finish_all_tasks_or_not {
    static class Edge {
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
        return par[x] = find(par[x]); //path compression
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

    public static void createGraph(int[][] arr, ArrayList<ArrayList<Edge>> a, int v) {
        for (int i = 0; i < v; i++) {
            a.add(new ArrayList<>());
        }
        for (int i = 0; i < arr.length; i++) {
            a.get(arr[i][1]).add(new Edge(arr[i][1], arr[i][0]));
        }
    }

    public static boolean isPossible(ArrayList<ArrayList<Edge>> a, int v) {
        init(v);
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                Edge e = a.get(i).get(j);

                int parA = find(e.src);
                int parB = find(e.dest);

                if (parA == parB) {
                    return false;
                } else {
                    union(parA, parB);
                }

            }
        }

        return true;

    }

    public static void main(String[] args) {
        int v = 2;
        // int[][] arr = { { 1, 0 }, { 0, 1 } };
        int[][] arr = { { 1, 0 } };
        ArrayList<ArrayList<Edge>> a = new ArrayList<>();
        createGraph(arr, a, v);
        System.out.println(isPossible(a, v));
    }
}
