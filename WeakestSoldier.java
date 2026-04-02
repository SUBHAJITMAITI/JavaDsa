//Time Complexity: O(n·m + n log n)
//Space Complexity: O(n)

import java.util.PriorityQueue;

public class WeakestSoldier {
    public static class Row implements Comparable<Row> {

        int soldiers;
        int idx;

        Row(int idx, int count) {

            this.soldiers = count;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row s2) {
            if (this.soldiers == s2.soldiers) {
                return this.idx - s2.idx;
            } else {
                return this.soldiers - s2.soldiers;
            }
        }
    }

    public static void main(String[] args) {
        int army[][] = { { 1, 0, 0, 0 },
                { 1, 1, 1, 1 },
                { 1, 0, 0, 0 },
                { 1, 0, 0, 0 } };
        int k = 2;
        PriorityQueue<Row> pq = new PriorityQueue<>();

        //  PriorityQueue<Row> pq = new PriorityQueue<>(
        //     (r1, r2) -> (r1.soldiers == r2.soldiers) 
        //                   ? r1.idx - r2.idx 
        //                   : r1.soldiers - r2.soldiers
        // );
        
        for (int i = 0; i < army.length; i++) {
            int count = 0;
            for (int j = 0; j < army[i].length; j++) {
                count += army[i][j] == 1 ? 1 : 0;
            }
            pq.add(new Row(i, count));
        }
        for (int i = 0; i < k; i++) {
            System.out.println("R" + pq.remove().idx);
        }
    }
}
