import java.util.ArrayList;
import java.util.Arrays;

public class BipertiteGraph2 {
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
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }

    public static boolean dfs(ArrayList<Edge>[] graph) {
        int color[] = new int[graph.length];
        Arrays.fill(color, -1);
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                if (dfsutil(graph, color,0, i, -1, 1) % 2 == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int dfsutil(ArrayList<Edge>[] graph, int[] color,int col, int curr, int par, int c) {

        color[curr] = col;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (color[e.dest] == -1) {
                  col = color[curr] == 0 ? 1 : 0;
                if (dfsutil(graph, color,col, e.dest, curr, c + 1) != -1) {
                    int v = dfsutil(graph, color,col, e.dest, curr, c + 1);
                    return v;
                }
            }

            else if (color[e.dest] != color[curr]) {
                return c;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        /*
         * 1---3
         * / | \
         * 0 | 5--6
         * \ | /
         * 2---4
         * 
         */

        int v = 7;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        System.out.println(dfs(graph));

    }
}
