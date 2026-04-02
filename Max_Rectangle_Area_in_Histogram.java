// Time Complexity  =  O(n) optimized

import java.util.Stack;

public class Max_Rectangle_Area_in_Histogram {
    public static void MaxArea(int[] arr) { // tc=O(n)
        int MaxArea = 0;
        int NSR[] = new int[arr.length];
        int NSL[] = new int[arr.length];

        // Next_Smaller_Right - O(n)
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                NSR[i] = arr.length;
            } else {
                NSR[i] = s.peek();
            }
            s.push(i);
        }

        // Next_Smaller_Left - O(n)

        s = new Stack<>(); // here stack is empty
        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                NSL[i] = -1;
            } else {
                NSL[i] = s.peek();
            }
            s.push(i);
        }

        // current Area

        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int width = NSR[i] - NSL[i] - 1;
            int area = height * width;
            MaxArea = Math.max(MaxArea, area);
        }
        System.out.println("Max area in Histogram : " + MaxArea);
    }

    public static void main(String[] args) {
        int arr[] = { 2, 1, 5, 6, 2, 3 };
        // int arr[]={2,4};
        MaxArea(arr);
    }
}
