import java.util.*;

public class countWays {
    //function definition
    public static int countNum(int n) {
        int result = 0;
        if (n <= 1) {
            return n;
        } else {
            result = countNum(n - 1) + countNum(n - 2);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the number of stairs : ");
        int n = sc.nextInt();
        // function calling
        // relationship between count of stairs problem and fibonnaci series problem
        int result = countNum(n + 1);
        System.out.println("number of ways is : " + result);

    }
}
