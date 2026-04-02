//Time Complexity: O(n)
//Space Complexity: O(h) → O(log n) for balanced tree, O(n) for skewed tree

public class Maximum_Sum_BST_in_Binary_Tree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static class info {
        boolean isBST;
        int size;
        int sum;
        int min;
        int max;

        info(boolean isBST, int size, int sum, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.sum = sum;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxSum = 0;

    public static info maxBst(Node root) {
        if (root == null) {
            return new info(true, 0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        info left = maxBst(root.left);
        info right = maxBst(root.right);
        int size = left.size + right.size + 1;
        int sum = left.sum + right.sum + root.data;
        int min = Math.min(root.data, Math.min(left.min, right.min));
        int max = Math.max(root.data, Math.max(left.max, right.max));
        if (root.data <= left.max || root.data >= right.min) {
            return new info(false, size, sum, min, max);
        }
        if (left.isBST && right.isBST) {
            maxSum = Math.max(maxSum, sum);
            return new info(true, size, sum, min, max);
        }
        return new info(false, size, sum, min, max);
    }

    public static void main(String[] args) {
        // Root
        Node root = new Node(5);

        // Level 1
        root.left = new Node(9);
        root.right = new Node(2);

        // Level 2
        root.left.left = new Node(6);
        root.right.right = new Node(3);

        // Level 3
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(7);
        maxBst(root);
        System.out.println(maxSum);
    }
}
