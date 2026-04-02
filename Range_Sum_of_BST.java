//Time Complexity:
//Best: O(log N)
//Worst: O(N)
//Space Complexity:
//Balanced tree: O(log N)
//Skewed tree: O(N)

public class Range_Sum_of_BST {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int sum = 0;

    public static void sumOfRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data >= k1 && root.data <= k2) {
            sum += root.data;
            sumOfRange(root.left, k1, k2);
            // sum +=root.data;
            sumOfRange(root.right, k1, k2);
        }
        if (root.data < k1) {
            sumOfRange(root.right, k1, k2);
        } else {
            sumOfRange(root.left, k1, k2);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(8); // Root
        root.left = new Node(5); // Left child of 8
        root.right = new Node(11); // Right child of 8
        root.left.left = new Node(3); // Left child of 5
        root.left.right = new Node(6); // Right child of 5
        root.right.right = new Node(20); // Right child of 11
        sumOfRange(root, 5, 6);
        System.out.println(sum);
    }
}
