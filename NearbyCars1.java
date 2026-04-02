//Time Complexity: O(n log n)
//Space Complexity: O(n)

import java.util.Arrays;
public class NearbyCars1 {
    static class point {
        int idx;
        int dis;

        point(int idx, int dis) {

            this.dis = dis;
            this.idx = idx;

        }

    }

    public static void main(String[] args) {
        int pts[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k=2;
        point pts1[] = new point[pts.length];
        for (int i = 0; i < pts.length; i++) {
            int dis = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];
            pts1[i] = new point(i, dis);
        }
        Arrays.sort(pts1, (p1, p2) -> p1.dis - p2.dis);
        for (int i = 0; i < k; i++) {
            System.out.println("C" + pts1[i].idx);
        }
    }
}
