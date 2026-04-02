// Time complexity - O(n)

import java.util.Stack;

public class DuplicateParentheses {
    public static char opening(char s) {
        if (s == ')') {
            return '(';
        }

        else if (s == '}') {
            return '{';
        } else if (s == ']') {
            return '[';
        }
        return 'x';
    }

    public static boolean IsValid(String s) {
        Stack<Character> u = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            // closing
            if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                int count = 0;
                while (u.pop() != opening(s.charAt(i))) {
                    count++;
                }
                if (count < 1) {
                    return true;      // duplicate
                }
            }

            // opening
            else {
                u.push(s.charAt(i));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // valid string
        // String str = "((a+b))"; // true
        String str2 = "(a+b)"; // false
        System.out.println(IsValid(str2));
    }
}
