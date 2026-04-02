//Time Complexity  : o(n)
//Space Complexity: o(n)

import java.util.*;
import java.util.LinkedList;

public class Minimum_time_required_to_fill_given_N_slots {
    public static void main(String[] args) {
        // int N = 5, K = 5, arr[] = { 1, 2, 3, 4, 5 };
        int N = 6, K = 2, arr[] = { 2, 6 };
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        for (int i = 0; i < arr.length; i++) {
            visited[arr[i]] = true;
            q.add(arr[i]);
        }
        int time = 0;
        while (!q.isEmpty()) {
            time++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                if (curr - 1 >= 1 && !visited[curr - 1]) {
                    visited[curr - 1] = true;
                    q.add(curr - 1);
                }
                if (curr + 1 <= N && !visited[curr + 1]) {
                    visited[curr + 1] = true;
                    q.add(curr + 1);
                }
            }

        }
        System.out.println(time);
    }
}
