//Time Complexity: O(n + k log k)
//Space Complexity: O(n + k)

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


public class Sort_by_Frequency {
    public static String sort(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ? a.getKey() - b.getKey() : b.getValue() - a.getValue());

        for (Map.Entry<Character, Integer> e : hm.entrySet()) {
            pq.add(e);
        }
        StringBuilder d = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.poll().getKey();
            int val = hm.get(c);
            while (0 < val) {
                d.append(c);
                val = val - 1;
            }
        }
        return d.toString();
    }

    public static void main(String[] args) {
        String s = "cccaaa";
        System.out.println(sort(s));

    }
}
