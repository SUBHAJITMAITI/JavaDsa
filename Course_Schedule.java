//Time complexity: O(V⋅E)
//Space complexity: O(V+E)
import java.util.LinkedList;
import java.util.Queue;

public class Course_Schedule {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int arr[] = new int[numCourses];

        boolean[] visit = new boolean[numCourses];
        int connect[] = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int j = prerequisites[i][0];
            connect[j]++;
        }
        for (int i : connect) {
            System.out.print(i + " ");
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (connect[i] == 0) {
                q.add(i);
            }
        }
        int i = 0;
        while (!q.isEmpty()) {
            int k = q.remove();
            visit[k] = true;
            arr[i] = k;
            i++;

            for (int j = 0; j < prerequisites.length; j++) {
               
                if (prerequisites[j][1] == k) {
                    int h = prerequisites[j][0];
                    connect[h]--;
                    if (connect[h] == 0) {
                        q.add(prerequisites[j][0]);
                    }
                }
            }
        }
        
        
        if (i != numCourses)
            return new int[0];

        return arr;

    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        int numCourses = 4;
        int result[] = findOrder(numCourses, arr);
        System.out.println();
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
