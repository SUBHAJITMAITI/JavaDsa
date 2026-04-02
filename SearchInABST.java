//Time = O(H) → worst O(N), best O(log N).
//Space = O(H) recursion stack. Worst O(N), Best O(logN)
public class SearchInABST {
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

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        // boolean result = root.data > key ? search(root.left, key) : search(root.right, key);
        // return result;
        if (root.data > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public static void main(String[] args) {
        int values[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = nodeInsert(root, values[i]);
        }
        inorder(root);
        System.out.println();
        // System.out.println(search(root, 7));
        if (search(root, 6)) {
            System.out.println("found");
        } else {
            System.out.println("no found");
        }

    }
}
