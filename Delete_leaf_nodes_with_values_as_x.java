//Time Complexity: O(n)
//Space Complexity: O(h) → O(log n) for balanced tree, O(n) for skewed tree.

public class Delete_leaf_nodes_with_values_as_x {
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

    public static Node deleteLeaf(Node root, int x) {
        if (root == null) {
            return null;
        }

        root.left = deleteLeaf(root.left, x);
        root.right = deleteLeaf(root.right, x);

        if (root.left == null && root.right == null && root.data == x) {
            return null;
        }
        return root;
    }

    public static void preorder(Node root) { // O(n)
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(3);
        root.left.left = new Node(3);
        root.left.right = new Node(2);
        int x = 3;
        deleteLeaf(root, x);
        preorder(root);
    }
}
