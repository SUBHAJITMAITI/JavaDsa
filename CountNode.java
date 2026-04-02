//Time complexity : O(n) 
public class CountNode {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node BuildTree(int[] nodes) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = BuildTree(nodes);
            newNode.right = BuildTree(nodes);
            return newNode;
        }
    }

    public static int count = 0;

    public static void countnode(Node node) {
        if (node == null) {
            return;
        }
        count++;
        countnode(node.left);
        countnode(node.right);
    }

    // Another approach

    public static int countnode1(Node node) {
        if (node == null) {
            return 0;
        }

        int n = countnode1(node.left);
        int m = countnode1(node.right);
        return n + m + 1;
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.BuildTree(nodes);
        countnode(root);
        System.out.println(count);
        System.out.println(countnode1(root));
    }
}
