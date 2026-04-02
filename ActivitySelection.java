//Time = O(n log n)
//Space = O(n)
import java.util.*;

public class ActivitySelection {
    public static void main(String[] args) {

        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] end = { 2, 4, 6, 7, 9, 9 };

        // sorting
        int Activity[][] = new int[end.length][3];
        for (int i = 0; i < Activity.length; i++) {
            Activity[i][0] = i;
            Activity[i][1] = start[i];
            Activity[i][2] = end[i];
        }
        // lambda function -> shortform
        Arrays.sort(Activity, Comparator.comparingDouble(o -> o[2]));      //O(n log n)
        int maxAct = 0;

        ArrayList<Integer> a = new ArrayList<>();
        // 1st activity
        maxAct = 1;
        a.add(Activity[0][0]);

        int lastEnd = Activity[0][2];
        for (int i = 1; i < end.length; i++) {
            if (Activity[i][1] >= lastEnd) {
                // activity select
                maxAct++;
                lastEnd = Activity[i][2];
                a.add(Activity[i][0]);
            }
        }

        System.out.println("Max Activity : " + maxAct);
        for (int i = 0; i < a.size(); i++) {
            System.out.print("A" + a.get(i) + " ");
        }

    }
}
