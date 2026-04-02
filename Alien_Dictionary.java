//Time Complexity : O(N * L + K + E)
// Space Complexity: O(K + E)

import java.util.ArrayList;
import java.util.Stack;

public class Alien_Dictionary {
    public static String Find_Order(String[] dict, int k) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            a.add(new ArrayList<>());
        }
        for (int i = 0; i < dict.length - 1; i++) {
            String A = dict[i];
            String B = dict[i + 1];
            int len = Math.min(A.length(), B.length());
            for (int j = 0; j < len; j++) {
                if (A.charAt(j) != B.charAt(j)) {
                    a.get((int) A.charAt(j) - 'a').add((int) B.charAt(j) - 'a');
                    break;

                }
            }
        }
        boolean visited[] = new boolean[a.size()];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < a.size(); i++) {
            if (!visited[i]) {
                dfs(a, i, visited, s);
            }
        }
        StringBuilder w = new StringBuilder();

        while (!s.isEmpty()) {
            w.append((char) (s.pop() + 'a'));
        }

        return w.toString();
    }

    public static void dfs(ArrayList<ArrayList<Integer>> a, int i, boolean[] visited, Stack<Integer> s) {

        visited[i] = true;
        for (int j = 0; j < a.get(i).size(); j++) {
            int v = a.get(i).get(j);
            if (!visited[v]) {
                dfs(a, v, visited, s);
            }
        }
        s.add(i);

    }

    public static void main(String[] args) {
        String[] dict = { "caa", "aaa", "aab" };
        int k = 3;
        String order = Find_Order(dict, k);
        System.out.println("One valid order: " + order);
    }
}