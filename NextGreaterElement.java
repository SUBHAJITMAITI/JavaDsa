import java.util.*;

public class NextGreaterElement {
    public static void findNextGreaterRight(int[] arr, int[] nextgreater) { // Time Complexity = O(n) optimized
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {

            // 1 while

            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            // 2 if- else
            if (s.isEmpty()) {
                nextgreater[i] = -1;

            } else {
                nextgreater[i] = arr[s.peek()];
            }
            // 3 push in stack
            s.push(i);
        }

    }
    // next smaller right

    public static void findNextSmallerRight(int[] arr, int[] nextgreater) { // Time Complexity = O(n) optimized
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {

            // 1 while

            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            // 2 if- else
            if (s.isEmpty()) {
                nextgreater[i] = -1;

            } else {
                nextgreater[i] = arr[s.peek()];
            }
            // 3 push in stack
            s.push(i);
        }

    }

    // next greater left
    public static void findNextGreaterLeft(int[] arr, int[] nextgreater) { // Time Complexity = O(n) optimized
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {

            // 1 while

            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            // 2 if- else
            if (s.isEmpty()) {
                nextgreater[i] = -1;

            } else {
                nextgreater[i] = arr[s.peek()];
            }
            // 3 push in stack
            s.push(i);
        }
    }

    // next Smaller left
    public static void findNextSmallerLeft(int[] arr, int[] nextgreater) { // Time Complexity = O(n) optimized
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {

            // 1 while

            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            // 2 if- else
            if (s.isEmpty()) {
                nextgreater[i] = -1;

            } else {
                nextgreater[i] = arr[s.peek()];
            }
            // 3 push in stack
            s.push(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 6, 8, 0, 1, 3 };
        int nextgreaterRight[] = new int[arr.length];

        // next greater right
        findNextGreaterRight(arr, nextgreaterRight);
        for (int e : nextgreaterRight) {
            System.out.print(e + " ");
        }

        System.out.println();

        // next smaller right
        int nextgreaterRight1[] = new int[arr.length];
        findNextSmallerRight(arr, nextgreaterRight1);
        for (int e : nextgreaterRight1) {
            System.out.print(e + " ");
        }

        System.out.println();

        // next greater left
        int nextgreaterLeft2[] = new int[arr.length];

        findNextGreaterLeft(arr, nextgreaterLeft2);
        for (int e : nextgreaterLeft2) {
            System.out.print(e + " ");
        }

        System.out.println();

        // next Smaller left
        int nextgreaterLeft3[] = new int[arr.length];

        findNextSmallerLeft(arr, nextgreaterLeft3);
        for (int e : nextgreaterLeft3) {
            System.out.print(e + " ");
        }
    }
}