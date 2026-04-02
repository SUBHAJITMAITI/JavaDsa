//Time Complexity: O(V^3);
//Space Complexity: O(1);
public class Floyd_Warshall_Algorithm {
    final static int INF = 99999, V = 4;

    void floydWarshall(int graph[][]) {

        for (int v = 0; v < V; v++) {
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[i].length; j++) {

                    if (graph[i][v] == INF || graph[v][j] == INF) {
                        continue;
                    }
                    if (graph[i][j] > graph[i][v] + graph[v][j]) {
                        graph[i][j] = graph[i][v] + graph[v][j];
                    }
                }
            }

        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == INF) {
                    System.out.print("INF" + "  ");
                } else {
                    System.out.print(graph[i][j] + "  ");
                }
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int graph[][] = { { 0, 5, INF, 10 },
                { INF, 0, 3, INF },
                { INF, INF, 0, 1 },
                { INF, INF, INF, 0 } };
        Floyd_Warshall_Algorithm a = new Floyd_Warshall_Algorithm();
        a.floydWarshall(graph);
    }
}
