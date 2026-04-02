//Time complexity: O(V⋅E)
//Space complexity: O(V+E)
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Course_Schedule1 {

    public static void findOrder(int n, int[][] arr) {
        boolean[] visit = new boolean[n];
        boolean[] preStack = new boolean[n];
        Stack<Integer> s = new Stack<>();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] p : arr) {
            adj.get(p[1]).add(p[0]); // p[1] → p[0]
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                if (findOrderUtil(adj, arr, i, preStack, visit, s)) {
                    return;
                }
            }

        }
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static boolean findOrderUtil(List<List<Integer>> adj, int[][] arr, int i, boolean[] preStack,
            boolean[] visit, Stack<Integer> s) {

        visit[i] = true;
        preStack[i] = true;
        for (int neighbours : adj.get(i)) {
            {
                if (!visit[neighbours]) {

                    if (findOrderUtil(adj, arr, neighbours, preStack, visit, s)) {
                        return true;
                    }
                } else if (preStack[neighbours]) {
                    return true;
                }
            }

        }
        s.add(i);
        preStack[i] = false;
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        int numCourses = 4;
        findOrder(numCourses, arr);
        System.out.println();
    }
}
