// time complexity -O(n)
// space complexity -O(n)

import java.util.*;

public class FactorialFind {
    // function definition
    public static int FactorialFinding(int num) {
        int result = 0;
        // base case condition
        if (num == 0 || num == 1) {
            return 1;
        } 
        else {
            // recursive function calling
            result = num * FactorialFinding(num - 1);
            
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("ENTER THE NUMBER : ");
        int num = sc.nextInt();
        int result = FactorialFinding(num);
        System.out.println("factorial of a given number is : " + result);
    }
}
