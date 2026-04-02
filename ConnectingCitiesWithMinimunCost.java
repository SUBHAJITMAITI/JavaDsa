//Time Complexity: O(n^2 log n)
//Space Complexity: O(n^2)

import java.util.PriorityQueue;

public class ConnectingCitiesWithMinimunCost {
    static class Pair implements Comparable<Pair> {
        int node;
        int cost;

        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }

    public static int find(int cities[][]) {
        boolean[] visit = new boolean[cities.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int FinalCost = 0;
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!visit[curr.node]) {
                visit[curr.node] = true;
                FinalCost += curr.cost;
                for (int i = 0; i < cities.length; i++) {
                    if (cities[curr.node][i] != 0 && !visit[i]) {
                        pq.add(new Pair(i, cities[curr.node][i]));
                    }
                }
            }
        }

        return FinalCost;
    }

    public static void main(String[] args) {
        int cities[][] = { { 0, 1, 2, 3, 4 },
                         { 1, 0, 5, 0, 7 },
                         { 2, 5, 0, 6, 0 },
                         { 3, 0, 6, 0, 0 },
                         { 4, 7, 0, 0, 0 } };

        System.out.println(find(cities));
    }
}
