import java.util.ArrayList;
import java.util.Collections;

public class JobSequencing1 {
    public static class job {
        int id;
        int deadline;
        int profit;

        public job(int i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }
    }

    public static void main(String[] args) {
        int JobInfo[][] = { { 4, 45 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };
        ArrayList<job> jobs = new ArrayList<>();

        for (int i = 0; i < JobInfo.length; i++) {
            jobs.add(new job(i, JobInfo[i][0], JobInfo[i][1]));
        }

        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);
        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        int totalProfit = 0;
        for (int i = 0; i < jobs.size(); i++) {
            if (jobs.get(i).deadline > time) {
                time++;
                totalProfit += jobs.get(i).profit;
                seq.add(jobs.get(i).id);
            }
        }
        System.out.println("max jobs : " + seq.size());
        for (int i = 0; i < seq.size(); i++) {
            System.out.print(seq.get(i) + " ");
        }
        System.out.println("totalProfit : " + totalProfit);
    }

}
