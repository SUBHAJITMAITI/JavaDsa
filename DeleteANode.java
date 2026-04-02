//Insertion (all N values): O(N log N) average, O(N²) worst.
//Deletion: O(H) → O(log N) average, O(N) worst.
//Inorder Traversal: O(N).
//Space Complexity: O(H) = O(log N) average, O(N) worst.
public class DeleteANode {
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

    public static Node delete(Node root, int key) {
        if (root.data > key) {
            root.left = delete(root.left, key);
        } else if (root.data < key) {
            root.right = delete(root.right, key);
        } else {// voila case : where key equal to node value 
            // case 1-leaf node
            if (root.left == null && root.right == null) {
                return null;
            }
            // case 2 -single child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // case 3-both children
            Node is = findIS(root.right);
            root.data = is.data;
            root.right = delete(root.right, is.data);
        }
        return root;
    }

    public static Node findIS(Node root) {
        while (root.left != null) {
            root = root.left;
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
        int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = nodeInsert(root, values[i]);
        }
        inoder(root);
        System.out.println();
        root = delete(root, 10);
        inoder(root);
    }
}
