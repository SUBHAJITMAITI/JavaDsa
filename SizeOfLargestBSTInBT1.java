public class SizeOfLargestBSTInBT1 {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class info {
        boolean isBST;
        int size;
        int min;
        int max;

        info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBST = 0;

    public static boolean largestBST(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.data < min.data) {
            return false;
        }
        if (max != null && root.data > max.data) {
            return false;
        }
      
        boolean left = largestBST(root.left, min, root);
        boolean right = largestBST(root.right, root, max);
        return left && right;

    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        boolean f = largestBST(root,null,null);
        System.out.println(f);
        System.out.println("largest BST size = " + maxBST);
    }
}
