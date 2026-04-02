
//Time Complexity: O(n)
//Space Complexity: O(n)
import java.util.Stack;

public class Lexicographically_smallest_string_of_length_N_and_sum_K {
    public static Stack<Character> Find_Smallest_str(int n, int k) {
        Stack<Character> s = new Stack<>();
        while (n > 0) {
            n--;
            int put = Math.min(26, k - n);
            s.push((char) ('a' + (put - 1)));
            k = k - put;
        }
        return s;
    }

    // another approach
    public static String findSmallest(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int remaining = n - i - 1;
            int put = Math.max(1, k - 26 * remaining);
            if (put > 26){
                put = 26;
            }
            sb.append((char) ('a' + put - 1));
            k -= put;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int N = 5, K = 42;
        
        Stack<Character> s = Find_Smallest_str(N, K);
       
        while (!s.isEmpty()) {
            System.out.print(s.pop());
        }
         System.out.println();
        System.out.println(findSmallest(N, K));
    }
}
