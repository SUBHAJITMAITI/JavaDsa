// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.Stack;

public class Simplify_Path {

    public static String simplify(String s) {
        Stack<String> stack = new Stack<>(); // sc =O(n)
        String[] arr = s.split("/"); // tc and sc = O(n)
        for (String i : arr) { // tc=O(n)
            if (i.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!i.equals(".") && !i.equals("") && !i.equals("..")) {
                stack.push(i);
            }
        }
        StringBuilder u = new StringBuilder(""); // sc=O(n)
        // In Java, a Vector is a dynamic array class from the java.util package.Think
        // of it like an ArrayList
        // Even though Stack is LIFO for push/pop, it extends Vector in Java
        // A Vector stores elements internally in an array-like order: index 0 is the
        // oldest pushed element, index size-1 is the most recent.

        // The for (String j : stack) loop doesn’t pop elements — it iterates in index
        // order, starting from index 0 (bottom of the stack) to the top
        // So the loop goes from bottom to top because it’s just reading the internal
        // array of Vector.

        for (String j : stack) { // tc =O(n)
            u.append("/");
            u.append(j);
        }

        return u.length() == 0 ? "/" : u.toString();
    }

    public static void main(String[] args) {
        String s = "/apnacollege/";
        // String s= "/a/..";
        System.out.println(simplify(s));
    }
}
