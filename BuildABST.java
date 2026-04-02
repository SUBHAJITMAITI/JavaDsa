//Time Complexity:
//Worst: O(N²)
//Average: O(N logN)
//Space Complexity: O(N)

public class BuildABST {
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

    public static void inoder(Node root) {
        if (root == null) {
            return;
        }
        inoder(root.left);
        System.out.print(root.data + " ");
        inoder(root.right);
    }

    public static void main(String[] args) {
        int vlaues[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;
        for (int i = 0; i < vlaues.length; i++) {
            root = nodeInsert(root, vlaues[i]);
        }
        inoder(root);
        System.out.println();

    }
}
