//✅ Time Complexity: O(n)
//✅ Space Complexity: O(n)
import java.util.Stack;

public class Trapping_Rain_Water {
    public static int maxWater(int[] arr) {
        int maxWater = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] < arr[i]) {
                int pop_hight =arr[s.peek()];
                s.pop();
                if (s.isEmpty()) {
                    break;
                }
                int distance = i - s.peek() - 1;
                int hight = Math.min(arr[s.peek()], arr[i]) - pop_hight;
                maxWater += (distance * hight);
            }
            s.push(i);
        }
        return maxWater;
    }

    public static void main(String[] args) {
        int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.print(maxWater(arr));
    }
}
