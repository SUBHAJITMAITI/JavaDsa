//Time Complexity: O(n1 + n2)
//Space Complexity: O(h1 + h2)

import java.util.Stack;

public class TwoSumBSTs {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static int countPairs(Node root1, Node root2, int x) {
        if (root1 == null || root2 == null) {
            return 0;
        }
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        Node curr1 = root1, curr2 = root2;
        int count = 0;
        while (true) {
            while (curr1 != null) {
                s1.push(curr1);
                curr1 = curr1.left;
            }
            while (curr2 != null) {
                s2.push(curr2);
                curr2 = curr2.right;
            }
            if (s1.isEmpty() || s2.isEmpty()) {
                break;
            }
            Node t1 = s1.peek();
            Node t2 = s2.peek();
            int value = t1.data + t2.data;
            if (value == x) {
                System.out.println("(" + t1.data + "," + t2.data + ")");
                count++;
                s1.pop();
                s2.pop();
                curr1 = t1.right;
                curr2 = t2.left;

            }
             else if (value > x) {
                s2.pop();
                curr2 = t2.left;
            } else {
                s1.pop();
                curr1 = t1.right;
            }

        }

        return count;
    }

    public static void main(String[] args) {
        // BST 1
        Node root1 = new Node(5);
        root1.left = new Node(3);
        root1.right = new Node(7);
        root1.left.left = new Node(2);
        root1.left.right = new Node(4);
        root1.right.left = new Node(6);
        root1.right.right = new Node(8);

        // BST 2
        Node root2 = new Node(10);
        root2.left = new Node(6);
        root2.right = new Node(15);
        root2.left.left = new Node(3);
        root2.left.right = new Node(8);
        root2.right.left = new Node(11);
        root2.right.right = new Node(18);

        int x = 16;

        int ans = countPairs(root1, root2, x);
        System.out.println("Total Pairs = " + ans);
    }
}
