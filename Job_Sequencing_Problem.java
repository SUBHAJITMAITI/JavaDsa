// O(n log n) + O(n) + O(n × maxDeadline)≈ O(n log n + n × maxDeadline)
// If maxDeadline ≤ n, worst case = O(n²)
// Time Complexity: O(n log n + n × maxDeadline) → worst case O(n²)

// Space Complexity: O(maxDeadline) → worst case O(n)
//If maxDeadline ≤ n, then O(n)

import java.util.Arrays;

public class Job_Sequencing_Problem {

    // Job class to store id, deadline, and profit
    public static class Job {
        char id;
        int deadline;
        int profit;

        public Job(char id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    // Function to find maximum profit and schedule jobs
    public static void Find_Max_Profit(Job[] jobs) {
        // Step 1: Sort jobs in descending order of profit
        Arrays.sort(jobs, (j1, j2) -> j2.profit - j1.profit); // Time Complexity: O(n log n)

        // Step 2: Find the maximum deadline to determine size of schedule
        int maxDeadline = 0;
        for (Job job : jobs) { // Time Complexity: O(n)
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        // Arrays to keep track of scheduled jobs and filled slots
        char[] schedule = new char[maxDeadline];
        boolean[] slotFilled = new boolean[maxDeadline];

        int totalProfit = 0;

        // Step 3: Schedule each job in the latest available slot
        for (Job job : jobs) { // Outer loop → runs n times ,Inner loop → in worst case can run up to
                               // maxDeadline steps So Time complexity = O(n × maxDeadline)
            for (int j = job.deadline - 1; j >= 0; j--) {
                if (!slotFilled[j]) {
                    schedule[j] = job.id;
                    slotFilled[j] = true;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        // Step 4: Print scheduled jobs
        System.out.print("Scheduled Jobs: ");
        for (char id : schedule) {
            if (id != '\0') { // Skip empty slots
                System.out.print(id + " ");
            }
        }
        System.out.println();

        // Step 5: Print maximum profit
        System.out.println("Maximum Profit: " + totalProfit);
    }

    public static void main(String[] args) {
        Job[] jobs = {
                new Job('a', 4, 20),
                new Job('b', 1, 20),
                new Job('c', 1, 40),
                new Job('d', 1, 30)
        };

        Find_Max_Profit(jobs);
    }
}
