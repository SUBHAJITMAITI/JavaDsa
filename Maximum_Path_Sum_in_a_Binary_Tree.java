//Time Complexity: O(n)
//Space Complexity: O(h) (where h is tree height, i.e., O(log n) for balanced tree, O(n) for skewed tree).
public class Maximum_Path_Sum_in_a_Binary_Tree {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


    public static int maxSum = 0;

    public static int findMaxPath(Node root) {
        maxSum = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxSum;
    }

    public static int maxPathDown(Node root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, maxPathDown(root.left));
        int right = Math.max(0, maxPathDown(root.right));
        maxSum = Math.max(maxSum, left + right + root.data);
        return  root.data+Math.max(left, right);

    }

    public static void main(String[] args) {
        Node root = new Node(-10);
        root.left = new Node(-9);
        root.right = new Node(20);
        root.right.left = new Node(-15);
        root.right.right = new Node(-7);
        System.out.println(findMaxPath(root));
    }
}
