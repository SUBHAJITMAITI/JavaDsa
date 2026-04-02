// ✅ Time Complexity = O(n²)
// ✅ Space Complexity = O(n) (for recursion)
import java.util.*;

public class ReverseAStack {
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.add(top);

    }

    public static void reverse(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverse(s);
        pushAtBottom(s, top);

    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        // 3, 2, 1
        reverse(s);
        while (!s.isEmpty()) {
            System.out.print(s.peek() + " ");
            s.pop();
        }
        // 1 ,2 ,3
    }
}
