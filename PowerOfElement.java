//Approach : Recursion
//Time Complexity : O(log b)
import java.util.*;

public class PowerOfElement {
    public static int powerfind(int a, int b) {
        int mid = 0, result = 0, finalResult = 0;
        // Base case condition
        if (b == 1) {
            return a;
        }
        // recursive function calls
        else {
            mid = b / 2;
            result = powerfind(a, mid);
            finalResult = result * result;
            if (b % 2 == 0) {
                return finalResult;
            }
             else {
                return a * finalResult;
            }

        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of a and b : ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        // function calling
        int result = powerfind(a, b);
        System.out.println("power of a^b is : " + result);
    }
}