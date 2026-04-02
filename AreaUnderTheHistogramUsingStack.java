//Optimized Stack-Based Approach

// Time Complexity: O(N)
//Previous Smaller Elements (Left Pass):
//Each index is pushed and popped at most once from the stack.
//So this loop runs in O(N) time.

//Next Smaller Elements (Right Pass):
//Same logic — each element is pushed and popped at most once.
//So this loop also runs in O(N) time.

// Space Complexity: O(N)
//At most N elements in stack at once (in worst case like strictly increasing array)

//So: O(N)
import java.util.*;

public class AreaUnderTheHistogramUsingStack {
    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 5, 6, 3, 2, 4, 2};
        int n = arr.length;

        int[] prev = new int[n];
        int[] next = new int[n];
        int[] width = new int[n];
        int[] area = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Find previous smaller for each element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            prev[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // Clear stack for reuse
        stack.clear();

        // Find next smaller for each element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            next[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Calculate width and area
        int maxArea = 0;
        int maxIndex = -1;

        for (int i = 0; i < n; i++) {
            width[i] = next[i] - prev[i] - 1;
            area[i] = width[i] * arr[i];
            if (area[i] > maxArea) {
                maxArea = area[i];
                maxIndex = i;
            }
        }

        // Output
        System.out.println("Heights: " + Arrays.toString(arr));
        System.out.println("Prev Smaller Indices: " + Arrays.toString(prev));
        System.out.println("Next Smaller Indices: " + Arrays.toString(next));
        System.out.println("Widths: " + Arrays.toString(width));
        System.out.println("Areas: " + Arrays.toString(area));
        System.out.println("Max Area: " + maxArea + " (at height " + arr[maxIndex] + ")");
    }
}
