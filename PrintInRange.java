//Time Complexity: O(H + M), worst O(N)
//H = height of the BST
//M = number of nodes in range [k1, k2]
//Space Complexity: O(H), worst O(N), best O(logN)

public class PrintInRange {
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

    public static Node nodeInsert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (root.data > val) {
            // left subtree
            root.left = nodeInsert(root.left, val);
        } else {
            // right subtree
            root.right = nodeInsert(root.right, val);
        }
        return root;
    }

    public static void Printinrange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data >= k1 && root.data <= k2) {
            Printinrange(root.left, k1, k2);
            System.out.print(root.data + " ");
            Printinrange(root.right, k1, k2);

        } else if (root.data < k1) {
            Printinrange(root.right, k1, k2);

        } else {

            Printinrange(root.left, k1, k2);
        }
    }

    public static void main(String[] args) {
        int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = nodeInsert(root, values[i]);
        }
        Printinrange(root, 5, 12);
    }
}
