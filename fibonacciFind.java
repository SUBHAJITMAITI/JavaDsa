// time complexity -O(2^n)
// space complexity -O(n)


import java.util.Scanner;

public class fibonacciFind {
    // function definition
    public static int fibonacciFinding(int n) {
        int result = 0;
        // base case condition
        if (n <= 1) {
            return n;
        } else {
            // Recursive function call
            result = fibonacciFinding(n - 1) + fibonacciFinding(n - 2);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number in fibonacci series : ");
        int n = sc.nextInt();
        int result = fibonacciFinding(n);
        System.out.print("the final output is :" + result);
    }
}
