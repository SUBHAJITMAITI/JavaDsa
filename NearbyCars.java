//Time Complexity: O(n log n + k log n) ≈ O(n log n)
//Space Complexity: O(n)

import java.util.PriorityQueue;

public class NearbyCars {
    static class point implements Comparable<point> {
        int x;
        int y;
        int dis;
        int idx;

        point(int x, int y, int dis, int idx) {
            this.x = x;
            this.y = y;
            this.dis = dis;
            this.idx = idx;

        }

        @Override
        public int compareTo(point p2) {
            return this.dis - p2.dis;

        }
    }

    public static void main(String[] args) {
        int pts[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        PriorityQueue<point> pq = new PriorityQueue<>();
        int k = 2;
        for (int i = 0; i < pts.length; i++) { // O(n log n)
            int dis = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];
            pq.add(new point(pts[i][0], pts[i][1], dis, i));
        }

        // nearest k cars
        for (int i = 0; i < k; i++) {  //O(k log n)
            System.out.println("C" + pq.remove().idx);
        }
    }
}
