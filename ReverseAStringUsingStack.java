import java.util.*;

public class ReverseAStringUsingStack {

    public static String reverse(String u) {
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while (idx < u.length()) {
            s.push(u.charAt(idx));
            idx++;
        }

        StringBuilder b = new StringBuilder("");
        while (!s.isEmpty()) {
            b.append(s.pop());
        }
        return b.toString();
    }

    public static void main(String[] args) {
        String u = "subha";
       String s= reverse(u);
       System.out.println(s);

    }
}
