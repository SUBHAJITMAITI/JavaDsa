//Time Complexity : O(V + E)
//Space Complexity : O(V)
import java.util.ArrayList;

public class BipertiteGraph1 {
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
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));

    }

    public static boolean Isbipertite1(ArrayList<Edge>[] graph) {
        int color[] = new int[graph.length];
        for (int i = 0; i < color.length; i++) {
            color[i] = -1;
        }
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                if (!utilIsbipertite1(graph, i, 0, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean utilIsbipertite1(ArrayList<Edge>[] graph, int j, int c, int[] color) {
        color[j] = c;

        for (int i = 0; i < graph[j].size(); i++) {
            Edge e = graph[j].get(i);
            if (color[e.dest] == -1) {
                c = color[j] == 0 ? 1 : 0;
                if (!utilIsbipertite1(graph, e.dest, c, color)) {
                    return false;
                }
            } else if (color[e.dest] == color[j]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        System.out.println(Isbipertite1(graph));
    }
}
