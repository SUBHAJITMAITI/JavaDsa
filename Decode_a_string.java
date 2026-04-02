//Time Complexity: O(n + m)
//n = length of input string
//m = length of decoded output string
//Space Complexity: O(n + m)
//O(n) for the two stacks
//O(m) for the final decoded string

import java.util.Stack;

public class Decode_a_string {
    public static String decode(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int num = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(num);
                stringStack.push(curr);
                curr = new StringBuilder();
                num = 0;
            } else if (c == ']') {
                int repeatTimes = countStack.pop();
                StringBuilder decode = stringStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    decode.append(curr);
                }
                curr = decode;
            } else {
                curr.append(c);
            }

        }
        return curr.toString();

    }

    public static void main(String[] args) {
        System.out.println(decode("2[cv]")); // cvcv
        System.out.println(decode("3[b2[v]]")); // bvvbvvbvv
    }
}
