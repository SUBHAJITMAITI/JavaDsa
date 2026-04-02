//Time Complexity: O(N)
//Space Complexity: O(H) → worst O(N), best O(log N)
public class ValidBST {
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

    public static boolean Isbst(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.data <= min.data) {
            return false;
        }
        if (max != null && root.data >= max.data) {
            return false;
        }
        return Isbst(root.left, min, root) && Isbst(root.right, root, max);
    }

    public static void main(String[] args) {
        // int vlaues[] = { 8, 5, 3, 6, 10, 11, 14 };
        int vlaues[] = { 8, 4, 2, 1, 3, 6, 5, 7, 10, 11, 14 };
        // int vlaues[] = { 1, 1, 1 };
        Node root = null;
        for (int i = 0; i < vlaues.length; i++) {
            root = nodeInsert(root, vlaues[i]);
        }
        System.out.println(Isbst(root, null, null));
    }
}
