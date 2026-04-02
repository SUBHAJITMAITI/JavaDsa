// Time complexity - O(n)
import java.util.Stack;

public class ValidParentheses {
    public static boolean isMathch(char s, char u) {
        if (s == '(' && u == ')') {
            return true;
        }

        else if (s == '{' && u == '}') {
            return true;
        } else if (s == '[' && u == ']') {
            return true;
        }
        return false;
    }

    public static boolean valid(String s) {
        Stack<Character> u = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            //  opening 
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {

                u.push(s.charAt(i));

            } 
            //   closing
            else if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                if (u.isEmpty()) {
                    return false;
                }
                if (!isMathch(u.pop(), s.charAt(i))) {
                    return false;
                }
            }
        }

        if (u.isEmpty()) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String s = "]{{()}]";
        System.out.println(valid(s));

    }
}
