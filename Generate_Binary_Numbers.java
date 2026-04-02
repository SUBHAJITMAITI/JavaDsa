import java.util.LinkedList;
import java.util.Queue;

public class Generate_Binary_Numbers {
    // Time Complexity: O(n⋅logn)
    // Queue stores up to O(n) binary strings, each of length O(log n) . Space Complexity: O(n⋅logn)

    // using queue
    public static void Generate_Binary(int n) {
        Queue<String> s = new LinkedList<>();
        s.add("1");
        int i = 0;
        while (i < n) {
            String c = s.remove();
            System.out.print(c + " ");
            s.add(c + "0");
            s.add(c + "1");
            i++;
        }
        System.out.println();
    }

    // Time Complexity: O(nlogn)
    // Space Complexity:Recursion stack = O(log n) (max depth).
    // using recursion
    public static void Generate(int n) {
        if (n == 0) {
            return;
        }
        Generate(n / 2);
        System.out.print(n % 2);
    }

    public static void Generate_Binary1(int n) {
        for (int i = 1; i <= n; i++) {
            Generate(i);
            System.out.print(" ");
        }
        System.out.println();

    }

    //Time Complexity: O(nlogn)
    //Space Complexity:Only the string for one number at a time → O(log n).
    // using loop

    public static void Generate_Binary2(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(Integer.toBinaryString(i) + " ");

        }

    }

    public static void main(String[] args) {
        int n = 5;
        Generate_Binary(n);
        Generate_Binary1(n);
        Generate_Binary2(n);
    }
}
