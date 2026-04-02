//Time complexity → O(m log m + n log n)
//Space complexity → O(m + n)

import java.util.Arrays;
import java.util.Collections;

public class ChocolaProblem {
    public static void main(String[] args) {
        int n = 4, m = 6;
        Integer costVer[] = { 2, 1, 3, 1, 4 };// m-1 
        Integer costHor[] = { 4, 1, 2 };// n-1 
        Arrays.sort(costVer, Collections.reverseOrder()); // O(n log n)
        Arrays.sort(costHor, Collections.reverseOrder()); // O(m log m)
        int cost = 0;
        int h = 0, v = 0;
        int hp = 1;
        int vp = 1;
        while (v < costVer.length && h < costHor.length) {
            if (costHor[h] <= costVer[v]) { // vertical cut
                cost += (hp * costVer[v]);
                vp++;
                v++;
            } else { // horizontal cut
                cost += (vp * costHor[h]);
                hp++;
                h++;
            }
        }
        while (v < costVer.length) {
            cost += (hp * costVer[v]);
            vp++;
            v++;
        }
        while (h < costHor.length) {
            cost += (vp * costHor[h]);
            hp++;
            h++;
        }
        System.out.println("min cost of cuts = " + cost);
    }
}
