//  ✅ Time Complexity: O(n)
//✅ Space Complexity: O(n)

import java.util.Stack;

public class StockSpanProblem {
    public static void stockspan(int[] stock, int[] span) {
        Stack<Integer> s = new Stack<>();
        int i = 0;
        span[0] = 1;

        s.push(i);
        for (i = 1; i < span.length; i++) {
            while (!s.isEmpty() && stock[s.peek()] <= stock[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i + 1;

            } else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }

            s.push(i);

        }
    }

    public static void main(String[] args) {
        int stock[] = { 100, 80, 60, 70, 60, 85, 100 };
        int span[] = new int[stock.length];
        stockspan(stock, span);
        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        }

    }
}
