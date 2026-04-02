// Time complexity -O(n)
//Space Complexity -O(n)
import java.util.*;
import java.util.LinkedList;

public class FirstNon_Repeating_Letter {
    public static void non_repeating(String s) {
        int[] freq = new int[26];
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            q.add(s.charAt(i));
            freq[s.charAt(i) - 'a']++;
            while (!q.isEmpty() && freq[(q.peek() - 'a')] > 1) {
                q.remove();
            }
            if (q.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(q.peek()+" ");
            }
        }
    }

    public static void main(String[] args) {
        // String s = "aabccxb";
        String s = "abcabc";
        non_repeating(s);
    }
}
      