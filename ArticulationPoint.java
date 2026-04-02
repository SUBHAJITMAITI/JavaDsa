import java.util.ArrayList;

public class ArticulationPoint {
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
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        // graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        // graph[4].add(new Edge(4, 5));

        // graph[5].add(new Edge(5, 3));
        // graph[5].add(new Edge(5, 4));
    }

    static int time = 0;

    public static void dfs(ArrayList<Edge>[] graph, int curr, int par, int dt[], int low[], boolean visited[],
            boolean AP[]) {

        visited[curr] = true;
        dt[curr] = low[curr] = ++time;
        int child = 0;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i); // e.src ----e.dest
            int neigh = e.dest;
            if (neigh == par) {
                continue;

            } else if (visited[neigh]) {
                low[curr] = Math.min(low[curr], dt[neigh]);
            } else {
                dfs(graph, neigh, curr, dt, low, visited, AP);
                low[curr] = Math.min(low[curr], low[neigh]);
                if (par != -1 && dt[curr] <= low[neigh]) {
                    AP[curr] = true;
                }
                child++;
            }
        }

        if (par == -1 && child > 1) {
            AP[curr] = true;
        }

    }

    public static void getAP(ArrayList<Edge>[] graph, int v) {
        int dt[] = new int[v];
        int low[] = new int[v];
        boolean visited[] = new boolean[v];

        boolean AP[] = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs(graph, i, -1, dt, low, visited, AP);
            }
        }

        for (int i = 0; i < v; i++) {
            if (AP[i]) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        getAP(graph, v);
    }
}
