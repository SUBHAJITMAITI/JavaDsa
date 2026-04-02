//Time=(number of outputs)×(work per output)
//  =Cn​×O(n)
//Space Complexity
//Only recursion (printing directly) : O(n)

//If you store all valid strings in a list:
//Number of outputs = Catalan(n)
//Length of each string = 2n
//Output Space=O(Cn​×n)

//Catalan(n) is a special mathematical number that counts how many valid ways something can be formed under certain rules.
public class balanced_parentheses {
    public static void paren(int open, int close, int n, String s) {
        if (s.length() == n * 2) {
            System.out.println(s);
            return;
        }
        if (open < n) {
            paren(open + 1, close, n, s + "{");
        }
        if (close < open) {
            paren(open, close + 1, n, s + "}");
        }
    }

    public static void main(String[] args) {
        int n = 3;
        paren(0, 0, n, "");
    }
}
