//Time Complexity : O(V + E)
//Space Complexity : O(V + E)
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Detect_cycle_in_an_undirected_graph_using_BFS {
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
        graph[1].add(new Edge(0, 5));
        graph[1].add(new Edge(0, 9));

        graph[2].add(new Edge(2, 4));
        graph[2].add(new Edge(2, 5));

        graph[4].add(new Edge(4, 2));

        graph[5].add(new Edge(5, 1));
        graph[5].add(new Edge(5, 2));
        graph[5].add(new Edge(5, 9));

        graph[9].add(new Edge(9, 1));
        graph[9].add(new Edge(9, 5));

    }

    public static class info {
        int par;
        int node;

        info(int par, int node) {
            this.par = par;
            this.node = node;
        }
    }

    public static boolean bfs(ArrayList<Edge>[] graph) {
        boolean visit[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]) {
                if (bfsutil(graph, i, visit)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean bfsutil(ArrayList<Edge>[] graph, int i, boolean visit[]) { // O(V+E)
        Queue<info> q = new LinkedList<>();
        q.add(new info(-1, i)); // source=0
        while (!q.isEmpty()) {
            info curr = q.remove();
            if (!visit[curr.node]) { // visit curr
                // System.out.print(curr.node + " ");
                visit[curr.node] = true;
                for (int j = 0; j < graph[curr.node].size(); j++) {
                    Edge e = graph[curr.node].get(j);
                    if (visit[e.dest] && e.dest != curr.par) {
                        return true;
                    }
                    q.add(new info(curr.node, e.dest));
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int v = 10;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);

        System.out.println(bfs(graph));
    }
}
